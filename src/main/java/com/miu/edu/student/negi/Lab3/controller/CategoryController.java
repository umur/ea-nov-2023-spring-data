package com.miu.edu.student.negi.Lab3.controller;

import com.miu.edu.student.negi.Lab3.model.Category;
import com.miu.edu.student.negi.Lab3.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping()
    public List<Category>getAllCategories(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    public Category addCategory(@RequestBody Category category){
       return categoryService.addCategory(category);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category category,@PathVariable int id){
        return categoryService.updateCategory(id,category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable int id){
        categoryService.deleteCategoryById(id);
    }

}
