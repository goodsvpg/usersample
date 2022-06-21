package com.example.usersample.common.domain;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    METHOD_ARGUMENT_NOT_VALID(HttpStatus.BAD_REQUEST, "101", ""),

    CANNOT_FIND_USER(HttpStatus.UNPROCESSABLE_ENTITY, "102", "cannot find user"),
    CANNOT_FIND_ORDER(HttpStatus.UNPROCESSABLE_ENTITY, "103", "cannot find order");

    private HttpStatus httpStatus;
    private String code;
    private String message;

    ErrorCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
