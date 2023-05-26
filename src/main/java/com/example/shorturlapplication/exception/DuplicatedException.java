package com.example.shorturlapplication.exception;

public class DuplicatedException extends RuntimeException { // 중복된 url 등록하지 않도록
    public DuplicatedException() {
        super();
    }

    public DuplicatedException(String message) {
        super(message);
    }

    public DuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedException(Throwable cause) {
        super(cause);
    }

    protected DuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
