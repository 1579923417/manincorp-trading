package com.manincorp.trading.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.manincorp.trading.common.Constants;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import cn.hutool.core.util.ObjectUtil;
import com.manincorp.trading.entity.User;
import com.manincorp.trading.exception.CustomException;
import com.manincorp.trading.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * author: Jamie
 * Package: com.manincorp.trading.config.JwtInterceptor
 * Date: 2025-11-05 13:35
 * Description:Interceptor for validating JWT tokens in incoming HTTP requests.
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader(Constants.TOKEN);

        if (ObjectUtil.isEmpty(token) && request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (Constants.TOKEN.equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        String userId;
        try {
            String userToken = JWT.decode(token).getAudience().get(0);
            userId = userToken.split("-")[0];
            if (ObjectUtil.isEmpty(userId)) {
                throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
            }
        } catch (Exception e) {
            throw new CustomException(ResultCodeEnum.TOKEN_INVALID_ERROR);
        }

        User user = userService.getById(userId);
        if (ObjectUtil.isNull(user)){
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new CustomException(ResultCodeEnum.TOKEN_INVALID_ERROR);
        }

        return true;
    }
}
