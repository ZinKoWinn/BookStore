package com.zinko.bookstore.services.impl;

import com.zinko.bookstore.dto.RegisterDto;
import com.zinko.bookstore.models.Role;
import com.zinko.bookstore.models.entities.User;
import com.zinko.bookstore.repositories.UserRepository;
import com.zinko.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean exitsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    public User register(RegisterDto registerDto) {
        User user = new User();
        user.setName(registerDto.getUsername());
        user.setImageUrl(registerDto.getImageUrl());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setRegistrationDate(LocalDate.now());
        user.setRoles(Role.ROLE_ADMIN);
        return create(user);
    }


    @Override
    public boolean emptyUser() {
        return userRepository.count() == 0;
    }

    @Override
    public boolean existsById(int id) {
        return userRepository.existsById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }
}
