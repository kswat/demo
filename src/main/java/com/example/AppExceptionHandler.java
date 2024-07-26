package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(DuplicateException.class)
    public ProblemDetail duplicateError(DuplicateException duplicateEx){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, duplicateEx.getMessage());
    }
}
