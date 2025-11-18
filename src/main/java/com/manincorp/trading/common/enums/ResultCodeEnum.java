package com.manincorp.trading.common.enums;

public enum ResultCodeEnum {
    SUCCESS("200", "成功"),

    PARAM_ERROR("400", "参数异常"),
    TOKEN_INVALID_ERROR("401", "无效的token"),
    TOKEN_CHECK_ERROR("401", "token验证失败，请重新登录"),
    PARAM_LOST_ERROR("4001", "参数缺失"),

    SYSTEM_ERROR("500", "系统异常"),
    USER_EXIST_ERROR("5001", "用户名已存在"),
    USER_NOT_LOGIN("5002", "用户未登录"),
    USER_ACCOUNT_ERROR("5003", "账号或密码错误"),
    USER_NOT_EXIST_ERROR("5004", "用户不存在"),
    PARAM_PASSWORD_ERROR("5005", "原密码输入错误"),
    USER_NO_PERMISSION_ERROR("5006", "普通用户无权限登录后台"),

    ALREADY_FAVORITE("5007", "该产品已收藏，无需重复收藏"),
    NO_FAVORITE_FOUND("5008", "未找到收藏记录"),

    UPLOAD_FILE_EMPTY("5009", "上传文件为空，请选择文件上传"),

    MAIL_SEND_ERROR("5010", "邮件发送错误"),
    VERIFICATION_CODE_EXPIRED("5011", "验证码已过期"),
    VERIFICATION_CODE_ERROR("5012", "验证码错误"),

    ENUM_NOT_FOUND("5013", "不存在对应的枚举值"),

    PRODUCT_NOT_EXIST_ERROR("5014", "产品不存在")
    ;   ;

    public String code;
    public String msg;

    ResultCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
