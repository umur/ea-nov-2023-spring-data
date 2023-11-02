package com.example.assignment2springdata.services;

import com.example.assignment2springdata.models.Category;

import java.util.List;

public interface CategoryService {
    void create(Category category);

    List<Category> findAll();

    void update(Category category);

    Category getCategory(Long id);

    void delete(Category category);

    Category findByName(String name);
}
