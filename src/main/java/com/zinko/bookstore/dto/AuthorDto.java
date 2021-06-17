package com.zinko.bookstore.dto;

import com.zinko.bookstore.models.entities.Author;
import lombok.Data;

@Data
public class AuthorDto {
    private int id;
    private String name;
    private String imageUrl;
    private String about;

    public AuthorDto() {
    }

    public AuthorDto(int id, String name, String imageUrl, String about) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.about = about;
    }

    public static Author toEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setImageUrl(authorDto.getImageUrl());
        author.setAbout(authorDto.getAbout());
        return author;
    }

    public static AuthorDto fromEntity(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getName(),
                author.getImageUrl(),
                author.getAbout()
        );
    }
}
