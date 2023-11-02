package com.example.lab2.controller;

import com.example.lab2.dto.CategoryDto;
import com.example.lab2.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.lab2.service.CategoryService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public void saveCategory(@RequestBody Category categoryDto) {
        categoryService.save(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable int id, @RequestBody Category categoryDto) {
        categoryService.update(id, categoryDto);
    }
}
