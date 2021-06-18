package com.zinko.bookstore.mapper.impl;

import com.zinko.bookstore.dto.RegisterDto;
import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.mapper.RegisterMapper;
import com.zinko.bookstore.models.Role;
import com.zinko.bookstore.models.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RegisterMapperImpl implements RegisterMapper {
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
}
