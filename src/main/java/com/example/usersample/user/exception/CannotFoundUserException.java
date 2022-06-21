package com.example.usersample.user.exception;

import com.example.usersample.common.domain.ErrorCode;
import com.example.usersample.common.exception.CustomException;

public class CannotFoundUserException extends CustomException {
    public CannotFoundUserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
