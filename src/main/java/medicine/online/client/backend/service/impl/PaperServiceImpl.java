package medicine.online.client.backend.service.impl;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import medicine.online.client.backend.common.cache.RedisCache;
import medicine.online.client.backend.common.cache.RedisKeys;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.common.cache.TokenStoreCache;
import medicine.online.client.backend.common.constant.Constant;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.mapper.BankMapper;
import medicine.online.client.backend.mapper.PaperMapper;
import medicine.online.client.backend.model.dto.PaperBankQuestion;
import medicine.online.client.backend.model.entity.Paper;
import medicine.online.client.backend.model.query.QuestionQuery;
import medicine.online.client.backend.model.vo.UserLoginVO;
import medicine.online.client.backend.service.PaperService;
import medicine.online.client.backend.utils.JwtUtil;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/15 21:01
 * @description:
 **/
@Service
@Slf4j
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {
    @Resource
    private PaperMapper paperMapper;
    @Resource
    private BankMapper bankMapper;
    @Resource
    private RedisCache redisCache;
    @Resource
    private TokenStoreCache tokenStoreCache;
    @Resource
    private HttpServletRequest request;

   @Override
    public PageResult<PaperBankQuestion> getPaperQuestionsByPaperId(QuestionQuery query) {
        try {
            if (query.getQuizExamId() != null) {
                // 从请求头获取token
                String token = request.getHeader("Authorization");
                if (token != null) {
                    JSONObject claims = JwtUtil.getJSONObject(token);
                    Integer userId = claims.getInt("userId");
                    
                    if (userId != null) {
                        String key = RedisKeys.getQuizUserPaperId(query.getQuizExamId());
                        redisCache.hSet(key, String.valueOf(userId), RedisCache.HOUR_SIX_EXPIRE);
                        log.info("Redis存储结果 - key: {}, value: {}", key, userId);
                    }
                } else {
                    log.warn("未获取到token");
                }
            }
        } catch (Exception e) {
            log.error("Redis缓存失败: ", e);
        }
        
        Page<PaperBankQuestion> page = new Page<>(query.getPage(), query.getLimit());
        List<PaperBankQuestion> questions = baseMapper.getPaperQuestions(page, query.getPaperId());
        
        return new PageResult<>(questions, page.getTotal());
    }
}
