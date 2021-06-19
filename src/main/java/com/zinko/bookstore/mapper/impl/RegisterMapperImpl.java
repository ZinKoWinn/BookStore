package com.zinko.bookstore.mapper.impl;

import com.zinko.bookstore.dto.RegisterDto;
import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.mapper.EntityMapper;
import com.zinko.bookstore.models.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RegisterMapperImpl implements EntityMapper<UserDto,RegisterDto> {
    @Override
    public UserDto mapToEntity(RegisterDto registerDto) {
        UserDto user = new UserDto();
        user.setName(registerDto.getUsername());
        user.setImageUrl(registerDto.getImageUrl());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setRegistrationDate(LocalDate.now());
        user.setRoles(Role.ROLE_ADMIN);
        return user;
    }

    @Override
    public RegisterDto mapFromEntity(UserDto userDto) {
        return null;
    }
}
