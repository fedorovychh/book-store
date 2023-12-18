package com.app.bookstore.service.user;

import com.app.bookstore.dto.UserRegistrationRequestDto;
import com.app.bookstore.dto.UserResponseDto;
import com.app.bookstore.exception.RegistrationException;
import com.app.bookstore.mapper.UserMapper;
import com.app.bookstore.model.User;
import com.app.bookstore.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Can't register user");
        }
        User user = userMapper.toUser(requestDto);
        return userMapper.toDto(userRepository.save(user));
    }
}
