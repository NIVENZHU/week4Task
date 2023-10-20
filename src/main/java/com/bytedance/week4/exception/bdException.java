package com.bytedance.week4.exception;

/**
 * 统一的异常返回
 */
public class bdException extends RuntimeException {
    private final Integer code;
    private final String message;

    public bdException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public bdException(bdExceptionEnum exceptionEnum){
        this(exceptionEnum.getCode(),exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
