package com.example.usersample.common.handler;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerHandler {

    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.initDirectFieldAccess();
    }
}
