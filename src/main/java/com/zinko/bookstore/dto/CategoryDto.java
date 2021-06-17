package com.zinko.bookstore.dto;

import com.zinko.bookstore.models.entities.Category;
import lombok.Data;

@Data
public class CategoryDto {
    private int id;
    private String name;
    private String description;
    private String imageUrl;

    public CategoryDto() {
    }

    public CategoryDto(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getPhotosImagePath() {
        return "/category-photos/" + id + "/" + imageUrl;
    }

    public static Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setImageUrl(categoryDto.getImageUrl());
        category.setDescription(categoryDto.getDescription());
        return category;
    }

    public static CategoryDto fromEntity(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}
