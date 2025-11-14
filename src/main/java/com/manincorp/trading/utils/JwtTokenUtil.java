package com.manincorp.trading.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.manincorp.trading.common.Constants;
import com.manincorp.trading.common.enums.RoleEnum;
import com.manincorp.trading.entity.User;
import com.manincorp.trading.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

/**
 * author: Jamie
 * Package: com.manincorp.trading.utils.JwtTokenUtil
 * Date: 2025-11-05 11:27
 * Description: Utility class for creating and validating JWT tokens.
 */
@Component
public class JwtTokenUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

    private static UserService staticUserService;

    @Resource
    UserService userService;

    @PostConstruct
    public void setUserService() {
        staticUserService = userService;
    }

    /**
     * Create a new JWT token.
     * @param data
     * @param sign
     * @return
     */
    public static String createToken(String data, String sign) {
        return JWT.create().withAudience(data)
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(sign));
    }

    /**
     * Retrieve the information of the currently logged-in user
     */
    public static User getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader(Constants.TOKEN);
            if (ObjectUtil.isNotEmpty(token)) {
                String userRole = JWT.decode(token).getAudience().get(0);
                String Id = userRole.split("-")[0];
                String role = userRole.split("-")[2];
                if (RoleEnum.ADMIN.name().equals(role)) {
                    return staticUserService.getById(Id);
                }
            }
        } catch (Exception e) {
            log.error("获取当前用户信息出错", e);
        }
        return new User();
    }
}
