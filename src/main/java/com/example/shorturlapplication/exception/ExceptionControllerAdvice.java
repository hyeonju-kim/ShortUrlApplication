package com.example.shorturlapplication.exception;

import com.example.shorturlapplication.controller.UrlController;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
//@RestControllerAdvice
@ControllerAdvice
public class ExceptionControllerAdvice {
    // 특정한 사이트 차단
    @ExceptionHandler(IllegalUrlException.class)
    public String illeUrl(IllegalUrlException e, Model model) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        model.addAttribute("message", message);
        model.addAttribute("status", status.value());

        return "error";
    }

    // 중복된 url 처리
    @ExceptionHandler(DuplicatedException.class)
    public String dupliEx(DuplicatedException e, Model model) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        model.addAttribute("message", message);
        model.addAttribute("status", status.value());

        return "error";
    }

    //ResponseDto
    @Data
    @AllArgsConstructor
    static class ResponseDto{
        private String code;
        private String msg;
    }
}
