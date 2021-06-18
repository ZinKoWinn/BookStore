package com.zinko.bookstore.mapper.impl;

import com.zinko.bookstore.dto.CategoryDto;
import com.zinko.bookstore.mapper.CategoryMapper;
import com.zinko.bookstore.models.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setImageUrl(categoryDto.getImageUrl());
        category.setDescription(categoryDto.getDescription());
        return category;
    }

    @Override
    public CategoryDto mapFromEntity(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getImageUrl(),
                category.getDescription()

        );
    }
}
