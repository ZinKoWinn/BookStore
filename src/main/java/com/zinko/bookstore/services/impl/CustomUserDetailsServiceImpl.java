package com.zinko.bookstore.services.impl;

import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.mapper.UserMapper;
import com.zinko.bookstore.models.CustomUserDetails;
import com.zinko.bookstore.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto user = userService.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException("User not found");
        System.out.println(user.getRoles().name());
        if(userService.exitsByEmail(user.getEmail())) System.out.println("True");
        return CustomUserDetails.build(user);
    }

}
