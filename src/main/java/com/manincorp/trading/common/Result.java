package com.manincorp.trading.common;

import com.manincorp.trading.common.enums.ResultCodeEnum;

public class Result {
    private String code;
    private String msg;
    private Object data;

    private Result(Object data) {
        this.data = data;
    }

    private Result(String code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(){
    }

    public static Result success() {
        return new Result(ResultCodeEnum.SUCCESS.code, ResultCodeEnum.SUCCESS.msg, null);
    }

    public static Result success(Object data){
        return new Result(ResultCodeEnum.SUCCESS.code, ResultCodeEnum.SUCCESS.msg, data);
    }

    public static Result success(String code, String msg, Object data){
        return new Result(code, msg, data);
    }

    public static Result error() {
        return new Result(ResultCodeEnum.SYSTEM_ERROR.code, ResultCodeEnum.SYSTEM_ERROR.msg, null);
    }

    public static Result error(ResultCodeEnum resultCodeEnum) {
        return new Result(resultCodeEnum.code, resultCodeEnum.msg, null);
    }

    public static Result error(String code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    public static Result error(String code, String msg) {
        Result tResult = new Result();
        tResult.setCode(code);
        tResult.setMsg(msg);
        return tResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
