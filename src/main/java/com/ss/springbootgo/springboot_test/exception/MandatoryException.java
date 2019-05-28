package com.ss.springbootgo.springboot_test.exception;

public class MandatoryException extends RuntimeException {
    public MandatoryException(String message) {
        super(message);
    }
}
