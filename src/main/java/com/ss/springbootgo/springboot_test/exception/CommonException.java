package com.ss.springbootgo.springboot_test.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter

public class CommonException extends RuntimeException {

    protected HttpStatus status;
    protected String code;

    CommonException(String message) {
        super(message);
    }


}
