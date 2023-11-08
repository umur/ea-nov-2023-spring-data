package com.example.labspringdata.controller;

import com.example.labspringdata.Service.CategoryService;
import com.example.labspringdata.entity.Address;
import com.example.labspringdata.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAll()
    {
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Category getById(@PathVariable int id)
    {
        return  categoryService.getById(id);
    }
    @PostMapping
    public Category save(@RequestBody Category category)
    {
        return categoryService.Save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable int id , @RequestBody Category category)
    {
        return  categoryService.update(id,category);
    }
}
