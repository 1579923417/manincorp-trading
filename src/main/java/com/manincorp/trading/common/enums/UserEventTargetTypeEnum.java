package com.manincorp.trading.common.enums;

import com.manincorp.trading.exception.CustomException;

/**
 * author: Jamie
 * Package: com.manincorp.trading.common.enums.UserEventTargetTypeEnum
 * Date: 2025-11-17 14:45
 * Description:
 */
public enum UserEventTargetTypeEnum {
    ARTICLE("article", "文章"),
    PRODUCT("product", "产品"),
    BRAND("brand", "品牌")

    ;

    public final String code;
    public final String msg;

    UserEventTargetTypeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static UserEventTargetTypeEnum fromCode(String code) {
        for (UserEventTargetTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new CustomException(ResultCodeEnum.ENUM_NOT_FOUND);
    }
}
