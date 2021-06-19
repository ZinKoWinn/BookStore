package com.zinko.bookstore.services.impl;

import com.zinko.bookstore.dto.RegisterDto;
import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.mapper.impl.RegisterMapperImpl;
import com.zinko.bookstore.mapper.impl.UserMapperImpl;
import com.zinko.bookstore.models.entities.User;
import com.zinko.bookstore.repositories.UserRepository;
import com.zinko.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RegisterMapperImpl registerMapper;
    @Autowired
    private UserMapperImpl userMapper;

    @Override
    public User create(UserDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(userMapper.mapToEntity(user));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user -> userMapper.mapFromEntity(user)).collect(Collectors.toList());
    }

    @Override
    public void update(UserDto user) {
        userRepository.save(userMapper.mapToEntity(user));
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findById(int id) {
        return userMapper.mapFromEntity(userRepository.findById(id));
    }

    @Override
    public UserDto findByUserName(String username) {
        return userMapper.mapFromEntity(userRepository.findByName(username));
    }

    @Override
    public UserDto findByEmail(String email) {
        return userMapper.mapFromEntity(userRepository.findByEmail(email));
    }


    @Override
    public boolean exitsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    public User register(RegisterDto registerDto) {
        return create(registerMapper.mapToEntity(registerDto));
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
