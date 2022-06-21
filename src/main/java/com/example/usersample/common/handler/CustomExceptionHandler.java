package com.example.usersample.common.handler;

import com.example.usersample.common.domain.ErrorCode;
import com.example.usersample.common.domain.ErrorResponse;
import com.example.usersample.common.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> argumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        FieldError fieldError = methodArgumentNotValidException.getBindingResult().getFieldError();
        return ResponseEntity
                .status(ErrorCode.METHOD_ARGUMENT_NOT_VALID.getHttpStatus())
                .body(ErrorResponse.builder()
                        .code(ErrorCode.METHOD_ARGUMENT_NOT_VALID.getCode())
                        .message(fieldError.getField() + ":" + fieldError.getDefaultMessage())
                        .build()
                );
    }

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> customException(CustomException customException) {
        ErrorCode errorCode = customException.getErrorCode();
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ErrorResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build()
                );
    }
}
