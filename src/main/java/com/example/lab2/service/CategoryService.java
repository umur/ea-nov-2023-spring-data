package com.example.lab2.service;

import com.example.lab2.dto.CategoryDto;
import com.example.lab2.entity.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);

    List<CategoryDto> findAll();

    CategoryDto findById(int id);

    void deleteById(int id);

    void update(int id,Category category);

}
