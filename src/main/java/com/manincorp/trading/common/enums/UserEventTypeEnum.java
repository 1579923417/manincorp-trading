package com.manincorp.trading.common.enums;

import com.manincorp.trading.exception.CustomException;

/**
 * author: Jamie
 * Package: com.manincorp.trading.common.enums.UserEventType
 * Date: 2025-11-17 14:41
 * Description:
 */
public enum UserEventTypeEnum {
    VIEW("view", "浏览"),
    FAVORITE("favorite", "收藏"),
    CLICK("click", "点击")

    ;

    public final String code;
    public final String msg;

    UserEventTypeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static UserEventTypeEnum fromCode(String code) {
        for (UserEventTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new CustomException(ResultCodeEnum.ENUM_NOT_FOUND);
    }
}
