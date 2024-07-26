package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateException extends RuntimeException {
    public DuplicateException(String itemAlreadyPresent) {
        super(itemAlreadyPresent);
    }

    public DuplicateException(String message, Exception cause) {
        super(message, cause);
    }
}
