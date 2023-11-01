package com.assginments.lab.service;

import java.util.List;

import com.assginments.lab.dto.CategoryDto;

public interface CategoryService {
    // findAll
    List<CategoryDto> findAll();

    // findById
    CategoryDto findById(int id);

    // Add
    void add(CategoryDto newAddress);

    // update
    void update(int id, CategoryDto updatedCategoryDto);

    // remove
    void remove(int id);
}
