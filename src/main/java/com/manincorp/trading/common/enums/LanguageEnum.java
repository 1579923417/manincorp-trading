package com.manincorp.trading.common.enums;

/**
 * author: Jamie
 * Package: com.manincorp.trading.common.enums.LanguageEnum
 * Date: 2025-11-20 11:06
 * Description:
 */
public enum LanguageEnum {
    ZH_HANS("zh-Hans", "简体中文"),
    ZH_HANT("zh-Hant", "繁体中文");

    private final String code;
    private final String desc;
    LanguageEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static LanguageEnum fromCode(String code) {
        for (LanguageEnum lang : values()) {
            if (lang.code.equalsIgnoreCase(code)) {
                return lang;
            }
        }
        throw new IllegalArgumentException("Unsupported language code: " + code);
    }
}
