package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    final CategoryService categoryService;

    @GetMapping()
    public List<CategoryDto> findAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping()
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

}
