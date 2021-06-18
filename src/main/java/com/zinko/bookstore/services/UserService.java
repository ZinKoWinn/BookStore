package com.zinko.bookstore.services;

import com.zinko.bookstore.dto.RegisterDto;
import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.models.entities.User;

import java.util.List;


public interface UserService {
    User create(UserDto user);

    List<UserDto> findAll();

    UserDto findById(int id);

    UserDto findByUserName(String username);

    UserDto findByEmail(String email);

    void update(UserDto user);

    void delete(int id);

    User register(RegisterDto registerDto);

    boolean exitsByEmail(String email);

    boolean existsById(int id);

    boolean emptyUser();

    long count();
}
