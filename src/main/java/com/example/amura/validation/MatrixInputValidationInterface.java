package com.example.amura.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = MatrixValidator.class)
@Documented
public @interface MatrixInputValidationInterface {
    String message() default "Matrix should contain 1 and 0 only";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
