package com.manincorp.trading.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * author: Jamie
 * Package: com.manincorp.trading.utils.JwtTokenUtil
 * Date: 2025-11-05 11:27
 * Description: Utility class for creating and validating JWT tokens.
 */
@Component
public class JwtTokenUtil {

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

}
