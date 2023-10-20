package com.bytedance.week4.exception;

public enum bdExceptionEnum {
    INSERT_FAILED(10000,"插入失败"),
    UPDATE_FAILED(10001,"编辑失败"),
    DELETE_FAILED(10002,"删除失败"),
    REQUEST_PARAM_ERROR(10003,"参数错误"),
    DUPLICATED_ERROR(10004,"数据库中已存在该条目"),
    NOT_NULL(10005,"参数不能为空"),
    USER_NOT_EXIST(10006,"用户不存在"),
    NEWS_NOT_EXIST(10007,"新闻不存在"),
    COMMENT_NOT_EXIST(10008,"评论不存在"),
    ADV_NOT_EXIST(10009,"广告不存在"),
    SYSTEM_ERROR(20000,"系统性错误");

    Integer code;
    String msg;

    bdExceptionEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
