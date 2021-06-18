package com.zinko.bookstore.mapper;

import com.zinko.bookstore.dto.AuthorDto;
import com.zinko.bookstore.models.entities.Author;

public interface AuthorMapper {

    Author mapToEntity(AuthorDto authorDto);
    AuthorDto mapFromEntity(Author author);
}
