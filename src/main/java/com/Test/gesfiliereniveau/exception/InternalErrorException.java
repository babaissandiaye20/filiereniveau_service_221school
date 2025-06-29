package com.Test.gesfiliereniveau.exception;

public class InternalErrorException extends ApiException {
    public InternalErrorException(String message) {
        super(message, 500);
    }
} 