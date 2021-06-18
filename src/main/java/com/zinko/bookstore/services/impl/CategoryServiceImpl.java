package com.zinko.bookstore.services.impl;

import com.zinko.bookstore.dto.CategoryDto;
import com.zinko.bookstore.mapper.CategoryMapper;
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
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category create(CategoryDto c) {
        return categoryRepository.save(categoryMapper.mapToEntity(c));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(category -> categoryMapper.mapFromEntity(category)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findByName(String name) {
        return categoryMapper.mapFromEntity(categoryRepository.findByName(name));
    }

    @Override
    public CategoryDto findById(int id) {
        return categoryMapper.mapFromEntity(categoryRepository.findById(id));
    }

    @Override
    public CategoryDto update(String name, int id) {
        return categoryMapper.mapFromEntity(categoryRepository.update(name, id));
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
