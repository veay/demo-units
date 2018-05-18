package com.lee.exception;

/**
 * @author jack
 * @since 2018/5/17
 */
public class AppointException extends RuntimeException {

    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }

}