package com.zinko.bookstore.mapper.impl;

import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.mapper.UserMapper;
import com.zinko.bookstore.models.Role;
import com.zinko.bookstore.models.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setImageUrl(userDto.getImageUrl());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(Role.ROLE_USER);
        user.setRegistrationDate(userDto.getRegistrationDate());
        return user;
    }

    @Override
    public UserDto mapFromEntity(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getImageUrl(),
                user.getEmail(),
                user.getPassword(),
                user.getRegistrationDate(),
                user.getRoles()
        );
    }
}
