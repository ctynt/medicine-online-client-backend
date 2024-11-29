package medicine.online.client.backend.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.common.cache.TokenStoreCache;
import medicine.online.client.backend.common.constant.Constant;
import medicine.online.client.backend.common.exception.ErrorCode;
import medicine.online.client.backend.common.exception.ServerException;
import medicine.online.client.backend.model.vo.UserLoginVO;
import medicine.online.client.backend.service.UserService;
import medicine.online.client.backend.utils.JwtUtil;

@Slf4j
@AllArgsConstructor
@Component
public class TokenInterceptor implements HandlerInterceptor {
    private final TokenStoreCache tokenStoreCache;
    private final UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {
        String accessToken = JwtUtil.getAccessToken(request);
        if (StringUtils.isBlank(accessToken)){
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }

        if(!JwtUtil.validate(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }

        UserLoginVO user = tokenStoreCache.getUser(accessToken);
        if(ObjectUtils.isEmpty(user)) {
            throw new ServerException(ErrorCode.LOGIN_STATUS_EXPIRE);
        }

        boolean enabledFlag = userService.checkUserEnabled(user.getUserId());

        if(!enabledFlag) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }

        RequestContext.put(Constant.USER_ID,user.getUserId());
        return true;
    }

}
