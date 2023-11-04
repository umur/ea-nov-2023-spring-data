package com.assignemnts.assignment2.controller;

import com.assignemnts.assignment2.dto.get.GetFullCategoryDto;
import com.assignemnts.assignment2.dto.post.PostFullCategoryDto;
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
    public List<GetFullCategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public GetFullCategoryDto findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public GetFullCategoryDto save(@RequestBody PostFullCategoryDto fullCategoryDto) {
        return categoryService.save(fullCategoryDto);
    }

    @PutMapping("/{id}")
    public GetFullCategoryDto update(@RequestBody PostFullCategoryDto fullCategoryDto, @PathVariable Long id) {
        try {
            return categoryService.update(fullCategoryDto, id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }

    @DeleteMapping("/{id}")
    public GetFullCategoryDto delete(@PathVariable Long id) {
        try {
            return categoryService.delete(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }
}
