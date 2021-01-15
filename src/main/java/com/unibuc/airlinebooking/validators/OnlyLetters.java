package com.unibuc.airlinebooking.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OnlyLettersValidator.class)
public @interface OnlyLetters {

    String message() default "Only letters required.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
