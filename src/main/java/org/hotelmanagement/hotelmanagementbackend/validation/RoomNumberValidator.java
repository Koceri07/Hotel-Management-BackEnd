package org.hotelmanagement.hotelmanagementbackend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RoomNumberValidator implements ConstraintValidator<RoomNumber,Integer> {

    @Override
    public boolean isValid(Integer roomNumber, ConstraintValidatorContext constraintValidatorContext) {

        if (roomNumber < 0){
            return false;
        }
        return true;
    }
}
