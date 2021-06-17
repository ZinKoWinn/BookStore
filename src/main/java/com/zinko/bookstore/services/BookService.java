package com.zinko.bookstore.services;

import com.zinko.bookstore.dto.BookDto;
import com.zinko.bookstore.models.entities.Book;

import java.util.List;

public interface BookService {
    Book create(BookDto book);

    List<BookDto> findAll();

    List<BookDto> findByNameLike(String name);

    BookDto findById(int id);

    BookDto findByAuthor(int authorId);

    BookDto findByCategory(int categoryId);

    void update(BookDto book);

    void delete(int id);

    long count();

    boolean existsById(int id);

    boolean emptyBook();
}
