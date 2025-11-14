package com.manincorp.trading.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * author: Jamie
 * Package: com.manincorp.trading.utils.CodeGeneratorUtil
 * Date: 2025-11-14 15:21
 * Description: Utility class for generate verification code
 */
@Component
public class CodeGeneratorUtil {
    /**
     * Generate a verification code with the specific length
     */
    public static String generateCode(int length) {
        return UUID.randomUUID().toString().substring(0,length);
    }
}
