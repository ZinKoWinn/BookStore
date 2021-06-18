package com.zinko.bookstore.dto;

import lombok.Data;

@Data
public class CategoryDto {
    private int id;
    private String name;
    private String description;
    private String imageUrl;

    public CategoryDto() {
    }

    public CategoryDto(int id, String name, String imageUrl, String description) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getImagePath() {
        return "/appImages/categories/" + name + "/" + imageUrl;
    }

}
