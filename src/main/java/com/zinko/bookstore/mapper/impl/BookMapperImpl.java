package com.zinko.bookstore.mapper.impl;

import com.zinko.bookstore.dto.BookDto;
import com.zinko.bookstore.mapper.EntityMapper;
import com.zinko.bookstore.models.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements EntityMapper<Book,BookDto> {
    @Override
    public Book mapToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setPrice(bookDto.getPrice());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(bookDto.getAuthor());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setRate(bookDto.getRate());
        book.setImageUrl(bookDto.getImageUrl());
        book.setContent(bookDto.getContent());
        book.setQuantity(bookDto.getQuantity());
        return book;
    }

    @Override
    public BookDto mapFromEntity(Book book) {
        return new BookDto(
                book.getId(),
                book.getName(),
                book.getDescription(),
                book.getPrice(),
                book.getCategory(),
                book.getAuthor(),
                book.getPublishedDate(),
                book.getRate(),
                book.getImageUrl(),
                book.getContent(),
                book.getQuantity()
        );
    }
}
