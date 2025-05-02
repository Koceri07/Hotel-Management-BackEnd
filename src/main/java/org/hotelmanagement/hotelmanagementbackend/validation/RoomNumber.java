package org.hotelmanagement.hotelmanagementbackend.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RoomNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoomNumber {
    String message()default "room number is not negative";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
