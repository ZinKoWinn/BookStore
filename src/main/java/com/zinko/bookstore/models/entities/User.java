package com.zinko.bookstore.models.entities;

import com.zinko.bookstore.models.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String imageUrl;
    private String email;
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;
    @Enumerated(value = EnumType.STRING)
    private Role roles;
}
