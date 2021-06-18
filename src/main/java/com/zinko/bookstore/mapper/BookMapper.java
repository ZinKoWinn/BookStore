package com.zinko.bookstore.mapper;

import com.zinko.bookstore.dto.BookDto;
import com.zinko.bookstore.models.entities.Book;

public interface BookMapper {
    Book mapToEntity(BookDto bookDto);

    BookDto mapFromEntity(Book book);
}
