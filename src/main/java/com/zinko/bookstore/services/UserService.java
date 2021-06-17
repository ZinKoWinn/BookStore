package com.zinko.bookstore.services;

import com.zinko.bookstore.dto.RegisterDto;
import com.zinko.bookstore.models.entities.User;

import java.util.List;


public interface UserService {
    User create(User user);

    List<User> findAll();

    User findById(int id);

    User findByUserName(String username);

    User findByEmail(String email);

    User update(User user);

    void delete(int id);

    User register(RegisterDto registerDto);

    boolean exitsByEmail(String email);

    boolean existsById(int id);

    boolean emptyUser();

    long count();
}
