package com.zinko.bookstore.dto;

import com.zinko.bookstore.models.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private int id;
    private String name;
    private String imageUrl;
    private String email;
    private String password;
    private LocalDate registrationDate;
    private Role roles;

    public UserDto() {
    }

    public String getImagePath() {
        return "/appImages/users/Profile Images/" + name + "/" + imageUrl;
    }

    public UserDto(int id, String name, String imageUrl, String email, String password, LocalDate registrationDate, Role roles) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.roles = roles;
    }
}
