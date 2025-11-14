package com.manincorp.trading.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * author: Jamie
 * Package: com.manincorp.trading.utils.CurrentTimeUtil
 * Date: 2025-11-10 14:20
 * Description:
 */
@Component
public class CurrentTimeUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final ZoneId SHANGHAI_ZONE = ZoneId.of("Asia/Shanghai");

    public static String getNowTime() {
        return LocalDateTime.now(SHANGHAI_ZONE).format(FORMATTER);
    }
}
