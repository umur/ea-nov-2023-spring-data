package com.assginments.lab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assginments.lab.dto.CategoryDto;
import com.assginments.lab.service.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    // findAll
    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    // findById
    @GetMapping("{id}")
    public CategoryDto findByid(@PathVariable int id) {
        return categoryService.findById(id);
    }

    // Add
    @PostMapping
    public void addNew(@RequestBody CategoryDto categoryDto) {
        categoryService.add(categoryDto);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
        categoryService.update(id, categoryDto);
    }

    // remove
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        categoryService.remove(id);
    }
}
