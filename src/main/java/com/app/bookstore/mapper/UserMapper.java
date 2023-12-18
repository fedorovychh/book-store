package com.app.bookstore.mapper;

import com.app.bookstore.config.MapperConfig;
import com.app.bookstore.dto.UserRegistrationRequestDto;
import com.app.bookstore.dto.UserDto;
import com.app.bookstore.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserDto toDto(User user);

    User toUser(UserRegistrationRequestDto requestDto);
}
