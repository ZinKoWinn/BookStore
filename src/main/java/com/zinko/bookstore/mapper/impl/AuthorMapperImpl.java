package com.zinko.bookstore.mapper.impl;

import com.zinko.bookstore.dto.AuthorDto;
import com.zinko.bookstore.mapper.AuthorMapper;
import com.zinko.bookstore.models.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements AuthorMapper {
    @Override
    public Author mapToEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setImageUrl(authorDto.getImageUrl());
        author.setAbout(authorDto.getAbout());
        return author;
    }

    @Override
    public AuthorDto mapFromEntity(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getName(),
                author.getImageUrl(),
                author.getAbout()
        );
    }
}
