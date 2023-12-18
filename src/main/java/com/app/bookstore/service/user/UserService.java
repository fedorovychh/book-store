package com.app.bookstore.service.user;

import com.app.bookstore.dto.UserRegistrationRequestDto;
import com.app.bookstore.dto.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto);
}
