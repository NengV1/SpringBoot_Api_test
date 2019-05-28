package com.ss.springbootgo.springboot_test.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UnauthorizedException extends CommonException {

    private final HttpStatus status = HttpStatus.UNAUTHORIZED;
    private final String code = "401";

    public UnauthorizedException(String message) {
        super(message);
    }
}
