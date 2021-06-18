package com.zinko.bookstore.mapper;

import com.zinko.bookstore.dto.CategoryDto;
import com.zinko.bookstore.models.entities.Category;

public interface CategoryMapper {
    Category mapToEntity(CategoryDto categoryDto);

    CategoryDto mapFromEntity(Category category);
}
