package com.example.assignment2springdata.services.impl;

import com.example.assignment2springdata.models.Category;
import com.example.assignment2springdata.repository.CategoryRepo;
import com.example.assignment2springdata.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepo categoryRepo;
    @Override
    public void create(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void update(Long id, Category data) {
        Category category = categoryRepo.findById(id).get();
        if (category != null) {
            category.setName(data.getName());
            categoryRepo.save(category);
        }

    }

    @Override
    public Category getCategory(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Category findByName(String name) {
        return null;
    }
}
