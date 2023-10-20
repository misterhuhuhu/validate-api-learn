package com.mrwho;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CustomerValidValidator.class)
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR })
@Retention(RUNTIME)
@Documented
public @interface CustomerValid {

    String message() default "Customer firstName长度必须大于10 和lastName 长度必须大于5";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
