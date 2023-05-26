package com.example.shorturlapplication.exception;

import com.example.shorturlapplication.controller.UrlController;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class ExceptionControllerAdvice {
    // 특정한 사이트 차단
    @ExceptionHandler(IllegalUrlException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto illeUrl(IllegalUrlException e) {
        return new ResponseDto("400", e.getMessage());
    }

    // 중복된 url 처리
    @ExceptionHandler(DuplicatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto dupliEx(DuplicatedException e) {
        return new ResponseDto("500", e.getMessage());
    }

    //ResponseDto
    @Data
    @AllArgsConstructor
    static class ResponseDto{
        private String code;
        private String msg;
    }
}
