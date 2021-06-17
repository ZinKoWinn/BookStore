package com.zinko.bookstore.services;

import com.zinko.bookstore.dto.AuthorDto;
import com.zinko.bookstore.models.entities.Author;

import java.util.List;

public interface AuthorService {
    Author create(AuthorDto author);
    List<AuthorDto> findAll();
    AuthorDto findByName(String name);
    AuthorDto findById(int id);
    void update(AuthorDto author);
    void delete(int id);
    long count();
    boolean existsById(int id);
    boolean emptyAuthor();
}
