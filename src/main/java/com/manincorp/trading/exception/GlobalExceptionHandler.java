package com.manincorp.trading.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.manincorp.trading.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * author: Jamie
 * Package: com.manincorp.trading.exception.GlobalExceptionHandler
 * Date: 2025-11-05 16:54
 * Description: Global unified exception handler
 */
@ControllerAdvice(basePackages = "com.manincorp.trading.controller")
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.get();

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(HttpServletResponse request, Exception e) {
        log.error("异常信息：", e);
        return Result.error();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result customError(HttpServletRequest request, CustomException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

}
