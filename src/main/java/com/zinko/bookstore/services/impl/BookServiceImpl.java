package com.zinko.bookstore.services.impl;

import com.zinko.bookstore.dto.BookDto;
import com.zinko.bookstore.mapper.BookMapper;
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
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book create(BookDto book) {
        return bookRepository.save(bookMapper.mapToEntity(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(book -> bookMapper.mapFromEntity(book)).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByNameLike(String name) {
        if (name != null) {
            return bookRepository.findByNameLike("%".concat(name).concat("%")).stream().map(book -> bookMapper.mapFromEntity(book)).collect(Collectors.toList());
        }
        return findAll();
    }

    @Override
    public BookDto findById(int id) {
        return bookMapper.mapFromEntity(bookRepository.findById(id));
    }

    @Override
    public BookDto findByAuthor(int authorId) {
        return bookMapper.mapFromEntity(bookRepository.findByAuthor(authorId));
    }

    @Override
    public BookDto findByCategory(int categoryId) {
        return bookMapper.mapFromEntity(bookRepository.findByCategory(categoryId));
    }

    @Override
    public void update(BookDto book) {
        bookRepository.save(bookMapper.mapToEntity(book));
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
