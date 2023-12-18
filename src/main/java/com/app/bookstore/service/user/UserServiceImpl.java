package com.app.bookstore.service.user;

import com.app.bookstore.dto.UserRegistrationRequestDto;
import com.app.bookstore.dto.UserResponseDto;
import com.app.bookstore.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        return null;
    }
}
