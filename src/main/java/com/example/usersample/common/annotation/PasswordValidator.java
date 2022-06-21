package com.example.usersample.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    private static final String REG = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{10,}";

    @Override
    public void initialize(Password password){
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext cxt){
        return field.isEmpty() == false && field.matches(REG);
    }
}
