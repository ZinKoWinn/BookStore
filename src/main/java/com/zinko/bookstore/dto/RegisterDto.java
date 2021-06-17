package com.zinko.bookstore.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String imageUrl;
    private String email;
    private String password;
}
