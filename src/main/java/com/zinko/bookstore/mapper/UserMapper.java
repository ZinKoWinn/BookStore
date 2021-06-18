package com.zinko.bookstore.mapper;

import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.models.entities.User;

public interface UserMapper {
    User mapToEntity(UserDto userDto);

    UserDto mapFromEntity(User user);
}
