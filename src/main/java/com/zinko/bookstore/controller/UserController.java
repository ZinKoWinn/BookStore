package com.zinko.bookstore.controller;

import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<UserDto> allUser() {
        return userService.findAll();
    }

    @GetMapping("users/user/{name}")
    public UserDto findOne(@PathVariable String name) {
        return userService.findByUserName(name);
    }

    @PostMapping("users/user/update")
    public void updateUser(@RequestBody UserDto user) {
         userService.update(user);
    }

    @DeleteMapping("users/user/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (userService.existsById(id)) {
            userService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/count")
    public long count() {
        return userService.count();
    }


}
