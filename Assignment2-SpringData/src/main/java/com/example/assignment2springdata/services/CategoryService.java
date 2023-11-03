package com.example.assignment2springdata.services;

import com.example.assignment2springdata.models.Category;

import java.util.List;

public interface CategoryService {
    void create(Category category);

    List<Category> findAll();

    void update(Long id, Category category );

    Category getCategory(Long id);

    void delete(Long id);

    Category findByName(String name);
}
