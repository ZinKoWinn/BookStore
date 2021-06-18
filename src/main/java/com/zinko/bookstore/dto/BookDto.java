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
    private String imageUrl;
    private String content;
    private int quantity;

    public BookDto() {
    }

    public BookDto(int id, String name, String description, long price, Category category, Author author, LocalDate publishedDate, long rate, String imageUrl, String content, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.author = author;
        this.publishedDate = publishedDate;
        this.rate = rate;
        this.imageUrl = imageUrl;
        this.content = content;
        this.quantity = quantity;
    }

    public String getImagePath() {
        return "/appImages/books/" + name + "/" + imageUrl;
    }

}
