package com.manincorp.trading.exception;

import com.manincorp.trading.common.enums.ResultCodeEnum;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.exception.CustomException
 * Date: 2025-11-05 13:52
 * Description:Represents business-specific exceptions with a code and message.
 */
@Data
public class CustomException extends RuntimeException{
    private String code;
    private String msg;

    public CustomException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.code;
        this.msg = resultCodeEnum.msg;
    }

    public CustomException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
