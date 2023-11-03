package com.miu.edu.student.negi.Lab3.service;

import com.miu.edu.student.negi.Lab3.model.Category;
import com.miu.edu.student.negi.Lab3.model.Product;

import java.util.List;

public interface CategoryService {
    List<Category>getAllCategory();
    Category getCategoryById(int id);
    Category addCategory(Category category);
    Category updateCategory(int id,Category category);
    void deleteCategoryById(int id);
    List<Product>getAllproductFromCategory(Category category, double price);
}
