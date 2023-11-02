package com.assignemnts.assignment2.controller;

import com.assignemnts.assignment2.dto.FullCategoryDto;
import com.assignemnts.assignment2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<FullCategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public FullCategoryDto findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public FullCategoryDto save(@RequestBody FullCategoryDto fullCategoryDto) {
        return categoryService.save(fullCategoryDto);
    }

    @PutMapping("/{id}")
    public FullCategoryDto update(@RequestBody FullCategoryDto fullCategoryDto, @PathVariable Long id) {
        try {
            return categoryService.update(fullCategoryDto, id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }

    @DeleteMapping("/{id}")
    public FullCategoryDto delete(@PathVariable Long id) {
        try {
            return categoryService.delete(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }
}
