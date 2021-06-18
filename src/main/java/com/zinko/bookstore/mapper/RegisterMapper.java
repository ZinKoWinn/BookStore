package com.zinko.bookstore.mapper;

import com.zinko.bookstore.dto.RegisterDto;
import com.zinko.bookstore.dto.UserDto;

public interface RegisterMapper {
    UserDto mapToEntity(RegisterDto registerDto);
}
