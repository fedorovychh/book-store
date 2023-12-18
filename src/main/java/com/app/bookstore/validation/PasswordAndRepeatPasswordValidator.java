package com.app.bookstore.validation;

import com.app.bookstore.dto.UserRegistrationRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordAndRepeatPasswordValidator implements
        ConstraintValidator<PasswordAndRepeatPasswordEqual, UserRegistrationRequestDto> {
    @Override
    public boolean isValid(UserRegistrationRequestDto requestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return Objects.equals(requestDto.getPassword(), requestDto.getRepeatPassword());
    }
}
