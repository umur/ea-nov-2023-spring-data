package com.example.assignment2springdata.controllers;

import com.example.assignment2springdata.models.Category;
import com.example.assignment2springdata.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.create(category);
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable Long id) {
        categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
    }




}
