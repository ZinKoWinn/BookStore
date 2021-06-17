package com.zinko.bookstore.dto;

import com.zinko.bookstore.models.entities.Author;
import com.zinko.bookstore.models.entities.Book;
import com.zinko.bookstore.models.entities.Category;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDto {
    private int id;
    private String name;
    private String description;
    private long price;
    private Category category;
    private Author author;
    private LocalDate publishedDate;
    private long rate;
    private String content;
    private int quantity;

    public BookDto() {
    }

    public BookDto(int id, String name, String description, long price, Category category, Author author, LocalDate publishedDate, long rate, String content, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.author = author;
        this.publishedDate = publishedDate;
        this.rate = rate;
        this.content = content;
        this.quantity = quantity;
    }

    public static Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setPrice(bookDto.getPrice());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(bookDto.getAuthor());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setRate(bookDto.getRate());
        book.setContent(bookDto.getContent());
        book.setQuantity(bookDto.getQuantity());
        return book;
    }

    public static BookDto fromEntity(Book book) {
        return new BookDto(
                book.getId(),
                book.getName(),
                book.getDescription(),
                book.getPrice(),
                book.getCategory(),
                book.getAuthor(),
                book.getPublishedDate(),
                book.getRate(),
                book.getContent(),
                book.getQuantity()
        );
    }
}
