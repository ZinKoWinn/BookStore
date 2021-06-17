package com.zinko.bookstore.services.impl;

import com.zinko.bookstore.dto.CategoryDto;
import com.zinko.bookstore.models.entities.Category;
import com.zinko.bookstore.repositories.CategoryRepository;
import com.zinko.bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryDto c) {
        return categoryRepository.save(CategoryDto.toEntity(c));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(category -> CategoryDto.fromEntity(category)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findByName(String name) {
        return CategoryDto.fromEntity(categoryRepository.findByName(name));
    }

    @Override
    public CategoryDto findById(int id) {
        return CategoryDto.fromEntity(categoryRepository.findById(id));
    }

    @Override
    public CategoryDto update(String name, int id) {
        return CategoryDto.fromEntity(categoryRepository.update(name, id));
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

    @Override
    public boolean existsById(int id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public boolean emptyCategory() {
        return count() == 0;
    }
}
