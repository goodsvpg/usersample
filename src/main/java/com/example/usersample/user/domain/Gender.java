package com.example.usersample.user.domain;

import lombok.Getter;

@Getter
public enum Gender {
    WOMAN("W"), MAN("M"), EMPTY("");

    private String value;

    Gender(String value) {
        this.value = value;
    }
}
