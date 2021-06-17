package com.zinko.bookstore.services.impl;

import com.zinko.bookstore.dto.AuthorDto;
import com.zinko.bookstore.models.entities.Author;
import com.zinko.bookstore.repositories.AuthorRepository;
import com.zinko.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author create(AuthorDto author) {
        return authorRepository.save(AuthorDto.toEntity(author));
    }

    @Override
    public List<AuthorDto> findAll() {
        return authorRepository.findAll().stream().map(author -> AuthorDto.fromEntity(author)).collect(Collectors.toList());
    }

    @Override
    public AuthorDto findByName(String name) {
        return AuthorDto.fromEntity(authorRepository.findByName(name));
    }

    @Override
    public AuthorDto findById(int id) {
        return AuthorDto.fromEntity(authorRepository.findById(id));
    }

    @Override
    public void update(AuthorDto author) {
        authorRepository.save(AuthorDto.toEntity(author));
    }

    @Override
    public void delete(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public long count() {
        return authorRepository.count();
    }

    @Override
    public boolean existsById(int id) {
        return authorRepository.existsById(id);
    }

    @Override
    public boolean emptyAuthor() {
        return count() == 0;
    }
}