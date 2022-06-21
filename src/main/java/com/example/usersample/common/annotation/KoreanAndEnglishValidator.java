package com.example.usersample.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class KoreanAndEnglishValidator implements ConstraintValidator<KoreanAndEnglish, String> {
    private static final String REG = "^[가-힣a-zA-Z]*$";

    @Override
    public void initialize(KoreanAndEnglish koreanAndEnglish){
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext cxt){
        return field.isEmpty() == false && field.matches(REG);
    }
}
