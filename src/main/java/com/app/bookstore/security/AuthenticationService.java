package com.app.bookstore.security;

import com.app.bookstore.dto.UserLoginRequestDto;
import com.app.bookstore.dto.UserLoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private JwtUtil jwtUtil;

    public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto) {
        String generatedToken = jwtUtil.generateToken(requestDto.email());
        return null;
    }
}
