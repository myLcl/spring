package com.springData.exception;

/**
 * 自定义异常
 */
public class AppLoginException extends RuntimeException {
    public AppLoginException() {
        super("自定义错误");
    }

}
