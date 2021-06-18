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

    public String getImagePath() {
        return "/appImages/authors/" + name + "/" + imageUrl;
    }

}
