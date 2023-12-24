package com.app.bookstore.controller;

import com.app.bookstore.dto.user.UserLoginRequestDto;
import com.app.bookstore.dto.user.UserLoginResponseDto;
import com.app.bookstore.dto.user.UserRegistrationRequestDto;
import com.app.bookstore.dto.user.UserResponseDto;
import com.app.bookstore.exception.RegistrationException;
import com.app.bookstore.security.AuthenticationService;
import com.app.bookstore.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }

    @PostMapping(value = "/registration")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }
}
