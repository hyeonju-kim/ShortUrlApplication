package com.example.shorturlapplication.exception;

public class IllegalUrlException extends RuntimeException { // 특정 사이트 등록하지 못하도록
    public IllegalUrlException() {
        super();
    }

    public IllegalUrlException(String message) {
        super(message);
    }

    public IllegalUrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalUrlException(Throwable cause) {
        super(cause);
    }

    protected IllegalUrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
