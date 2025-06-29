package com.Test.gesfiliereniveau.exception;

import com.Test.gesfiliereniveau.response.ResponseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ResponseResponse<Object>> handleApiException(ApiException ex) {
        return ResponseEntity.status(ex.getCode())
                .body(ResponseResponse.builder()
                        .code(ex.getCode())
                        .status(HttpStatus.valueOf(ex.getCode()).name())
                        .data(null)
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseResponse<Object>> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(ResponseResponse.builder()
                .code(400)
                .status(HttpStatus.BAD_REQUEST.name())
                .data(null)
                .message(message)
                .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseResponse<Object>> handleOtherException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseResponse.builder()
                        .code(500)
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                        .data(null)
                        .message(ex.getMessage())
                        .build());
    }
} 