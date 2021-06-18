package com.zinko.bookstore.models;

import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.models.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;


public class CustomUserDetails implements UserDetails {
    private int id;
    private String name;
    private String email;
    private String password;
    private Collection authorities;
    private String imageUrl;
    private LocalDate registrationDate;

    public CustomUserDetails(int id, String name, String email, String password, Collection authorities, String imageUrl, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.imageUrl = imageUrl;
        this.registrationDate = registrationDate;
    }

    public static CustomUserDetails build(UserDto user) {
        SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(user.getRoles().name());
        return new CustomUserDetails(user.getId(), user.getName(), user.getEmail(), user.getPassword(), Arrays.asList(authorities), user.getImageUrl(), user.getRegistrationDate());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImagePath() {
        return "/appImages/users/Profile Images/" + name + "/" + imageUrl;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
