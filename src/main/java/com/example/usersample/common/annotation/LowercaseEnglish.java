package com.example.usersample.common.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LowercaseEnglishValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LowercaseEnglish {
    String message() default "Only lowercase letters in English is available";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
