package com.ea.dataone.controller;

import com.ea.dataone.entity.Category;
import com.ea.dataone.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void create(@RequestBody Category category) {
        categoryService.create(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PutMapping
    public void update(@RequestBody Category category) {
        categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Category category = categoryService.getCategory(id);
        categoryService.delete(category);
    }
}