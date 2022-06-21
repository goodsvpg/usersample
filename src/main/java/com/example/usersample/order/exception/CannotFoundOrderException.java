package com.example.usersample.order.exception;

import com.example.usersample.common.domain.ErrorCode;
import com.example.usersample.common.exception.CustomException;

public class CannotFoundOrderException extends CustomException {
    public CannotFoundOrderException(ErrorCode errorCode) {
        super(errorCode);
    }
}
