package com.softserve2020practice.annotations;

import com.softserve2020practice.validation.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {

    String message() default "Email is already taken, try another";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}