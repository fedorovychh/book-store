package com.app.bookstore.service.user;

import com.app.bookstore.dto.user.UserRegistrationRequestDto;
import com.app.bookstore.dto.user.UserResponseDto;
import com.app.bookstore.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}
