package com.zinko.bookstore.services.impl;

import com.zinko.bookstore.dto.BookDto;
import com.zinko.bookstore.models.entities.Book;
import com.zinko.bookstore.repositories.BookRepository;
import com.zinko.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book create(BookDto book) {
        return bookRepository.save(BookDto.toEntity(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(book -> BookDto.fromEntity(book)).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByNameLike(String name) {
        return bookRepository.findByNameLike("%".concat(name).concat("%")).stream().map(book -> BookDto.fromEntity(book)).collect(Collectors.toList());
    }

    @Override
    public BookDto findById(int id) {
        return BookDto.fromEntity(bookRepository.findById(id));
    }

    @Override
    public BookDto findByAuthor(int authorId) {
        return BookDto.fromEntity(bookRepository.findByAuthor(authorId));
    }

    @Override
    public BookDto findByCategory(int categoryId) {
        return BookDto.fromEntity(bookRepository.findByCategory(categoryId));
    }

    @Override
    public void update(BookDto book) {
        bookRepository.save(BookDto.toEntity(book));
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    public boolean existsById(int id) {
        return bookRepository.existsById(id);
    }

    @Override
    public boolean emptyBook() {
        return count() == 0;
    }
}
