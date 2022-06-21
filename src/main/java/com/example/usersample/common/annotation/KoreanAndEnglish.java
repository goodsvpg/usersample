package com.example.usersample.common.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = KoreanAndEnglishValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface KoreanAndEnglish {
    String message() default "Only Korean and English are available";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
