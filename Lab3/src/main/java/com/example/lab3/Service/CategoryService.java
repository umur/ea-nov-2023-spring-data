package com.example.lab3.Service;


import com.example.lab3.Model.Category;
import com.example.lab3.Model.Product;

import java.util.List;

public interface CategoryService {
    Category findById(int id);
    Category saveCategory(Category category);
    Category updateCategory(int id,Category category);
    void deleteCategory(int id);
}
