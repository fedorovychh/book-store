package com.app.bookstore.service.user;

import com.app.bookstore.dto.user.UserRegistrationRequestDto;
import com.app.bookstore.dto.user.UserResponseDto;
import com.app.bookstore.exception.RegistrationException;
import com.app.bookstore.mapper.UserMapper;
import com.app.bookstore.model.User;
import com.app.bookstore.repository.user.UserRepository;
import com.app.bookstore.service.shopping.cart.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final ShoppingCartService shoppingCartService;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(String.format(
                    "Can't register user with email %s", requestDto.getEmail())
            );
        }
        User user = userMapper.toUser(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        shoppingCartService.createShoppingCart(user);
        return userMapper.toDto(userRepository.save(user));
    }
}
