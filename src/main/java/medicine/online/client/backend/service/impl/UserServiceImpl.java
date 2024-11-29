package medicine.online.client.backend.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.cache.RedisCache;
import medicine.online.client.backend.common.cache.RedisKeys;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.common.cache.TokenStoreCache;
import medicine.online.client.backend.common.exception.ServerException;
import medicine.online.client.backend.enums.AccountStatusEnum;
import medicine.online.client.backend.common.exception.ErrorCode;
import medicine.online.client.backend.mapper.StudentMapper;
import medicine.online.client.backend.mapper.UserMapper;
import medicine.online.client.backend.model.dto.WxLoginDTO;
import medicine.online.client.backend.model.entity.Student;
import medicine.online.client.backend.model.entity.User;
import medicine.online.client.backend.model.vo.UserLoginVO;
import medicine.online.client.backend.service.UserService;
import medicine.online.client.backend.utils.AESUtil;
import medicine.online.client.backend.utils.CommonUtils;
import medicine.online.client.backend.utils.JwtUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static medicine.online.client.backend.common.constant.Constant.*;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final RedisCache redisCache;
    private final TokenStoreCache tokenStoreCache;
    private final StudentMapper studentMapper;

    @Override
    public UserLoginVO weChatLogin(WxLoginDTO loginDTO) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + APP_ID +
                "&secret=" + APP_SECRET +
                "&js_code=" + loginDTO.getCode() +
                "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(url, String.class);
        if (StringUtils.contains(jsonData, WX_ERR_CODE)) {
            // 出错了
            throw new ServerException("openId获取失败," + jsonData);
        }
        // 解析返回数据
        JSONObject jsonObject = JSON.parseObject(jsonData);
        log.info("wxData: {}", jsonData);
        String openid = Objects.requireNonNull(jsonObject).getString(WX_OPENID
        );
        String sessionKey = jsonObject.getString(WX_SESSION_KEY);
        // 对⽤户加密数据解密
        String jsonUserData = AESUtil.decrypt(loginDTO.getEncryptedData(), sessionKey, loginDTO.getIv());
        log.info("wxUserInfo: {}", jsonUserData);
        JSONObject wxUserData = JSON.parseObject(jsonUserData);
        User user = baseMapper.getByWxOpenId(openid);

        if (ObjectUtils.isEmpty(user)) {
            log.info("用户不存在，创建用户, openId: {}", openid);
            user = new User();
            user.setOpenId(openid);
            user.setNickname(wxUserData.getString("nickName"));
            user.setAvatar(wxUserData.getString("avatarUrl"));
            user.setSlogan("这个人很懒，什么都没有写");
            user.setIsEnable(AccountStatusEnum.ENABLED.getValue());
            user.setRole(1);
            user.setHospital(0);
            // 默认用户为江苏省南京市市辖区 对应pkId
            user.setProvince(876);
            user.setCity(877);
            user.setArea(878);

            Student student = new Student();
            student.setCityCode(320101);
            student.setName(user.getNickname());
            student.setSex(wxUserData.getInteger("gender"));
            student.setIsTest(0);
            student.setAge(20);
            student.setProfessionId(121);
            studentMapper.insert(student);
            user.setRoleId(1);
            baseMapper.insert(user);
        }

        // 用户被禁用
        if (!user.getIsEnable().equals(AccountStatusEnum.ENABLED.getValue())) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }

        // 判断是否绑定手机号
        boolean isPhoneBind = StringUtils.isNotBlank(user.getPhone());

        // 生成令牌
        String accessToken = JwtUtil.createToken(user.getPkId());

        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setUserId(user.getPkId());
        userLoginVO.setIsBind(isPhoneBind ? 1 : 0);
        userLoginVO.setPhone(user.getPhone());
        userLoginVO.setType(1);
        userLoginVO.setAccessToken(accessToken);
        userLoginVO.setOpenId(user.getOpenId());

        log.info("token生成: {}", accessToken);

        // 缓存用户信息
        tokenStoreCache.saveUser(accessToken, userLoginVO);
        return userLoginVO;
    }

    @Override
    public void logout(){
        // 从上下文中获取userId，然后获取redisKey
        String cacheKey = RedisKeys.getUserIdKey(RequestContext.getUserId());
        // 通过userId，获取redis中的 accessToken
        String accessToken =(String)redisCache.get(cacheKey);
        // 删除缓存中的 token
        redisCache.delete(cacheKey);
        // 删除缓存中的用户信息
        tokenStoreCache.deleteUser(accessToken);
    }

    @Override
    public void bindPhone(String phone, String code, String accessToken) {
        // 1. 校验手机号合法性
        if (!CommonUtils.checkPhone(phone)) {
            log.error("手机号格式不正确：{}", phone);
        }

        // 2. 校验验证码正确性
        String redisCode = redisCache.get(RedisKeys.getSmsKey(phone)).toString();
        if (org.springframework.util.ObjectUtils.isEmpty(redisCode) || !redisCode.equals(code)) {
            log.error("验证码错误或已过期，手机号：{}，输入验证码：{}", phone, code);
        }

        // 删除验证码缓存
        redisCache.delete(RedisKeys.getSmsKey(phone));

        // 3. 查询手机号是否已存在用户
        User userByPhone = baseMapper.getByPhone(phone);
        log.info("accessToken:{}",accessToken);

        // 获取当前登录用户信息
        UserLoginVO userLogin = tokenStoreCache.getUser(accessToken);

        if (userByPhone != null) {
            // 如果手机号属于其他用户，抛出异常
            if (!userLogin.getUserId().equals(userByPhone.getPkId())) {
                log.error("手机号 [{}] 已被用户 [{}] 使用", phone, userByPhone.getPkId());
            }

            // 如果手机号已是当前用户的手机号，提示重复绑定
            if (userLogin.getPhone().equals(phone)) {
                log.warn("用户 [{}] 绑定相同手机号 [{}]", userLogin.getUserId(), phone);
            }
        }

        // 4. 更新用户手机号
        User user = baseMapper.selectById(userLogin.getUserId());
        user.setPhone(phone);

        if (baseMapper.updateById(user) < 1) {
            log.error("用户 [{}] 更新手机号 [{}] 失败", userLogin.getUserId(), phone);
        }

        // 记录成功日志
        log.info("用户 [{}] 成功绑定新手机号 [{}]", userLogin.getUserId(), phone);
    }

    @Override
    public boolean checkUserEnabled(Integer userId){
        User user = baseMapper.selectById(userId);
        if(org.springframework.util.ObjectUtils.isEmpty(user)) {
            return false;
        }
        return user.getIsEnable().equals(AccountStatusEnum.ENABLED.getValue());
    }


}

