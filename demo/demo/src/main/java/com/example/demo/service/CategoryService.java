package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category findByName(String categoryName);

    public List<Category> getAllCategories();

    public Category getCategoryById(long id);
    public Category createCategory(Category category);

    public Category updateCategory(long id, Category category);

    public void deleteCategory(long id);
}
