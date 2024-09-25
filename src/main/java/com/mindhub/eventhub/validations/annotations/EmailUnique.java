package com.mindhub.eventhub.validations.annotations;

import com.mindhub.eventhub.validations.validators.EmailUniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = EmailUniqueValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface EmailUnique {
    String message() default "This email is already registered";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
