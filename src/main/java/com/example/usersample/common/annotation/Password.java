package com.example.usersample.common.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Must contain at least one uppercase, lowercase, special, and number each.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
