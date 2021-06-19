package com.zinko.bookstore.services;

import com.zinko.bookstore.dto.CategoryDto;
import com.zinko.bookstore.models.entities.Category;

import java.util.List;

public interface CategoryService {
    Category create(CategoryDto category);

    List<CategoryDto> findAll();

    CategoryDto findByName(String name);


    Category update(CategoryDto categoryDto);

    CategoryDto findById(int id);

    void delete(int id);

    long count();

    boolean existsById(int id);

    boolean emptyCategory();

}
