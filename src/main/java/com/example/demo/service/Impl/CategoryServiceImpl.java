package com.example.demo.service.Impl;


import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryRepo.findAll().forEach(category -> categoryDtoList.add(modelMapper.map(category, CategoryDto.class)));

        return categoryDtoList;
    }

    @Override
    public CategoryDto getCategoryById(int id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setId(null);
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(int id, CategoryDto categoryDto) {

        if (!categoryRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id: " + id);
        }

        Category category = modelMapper.map(categoryDto, Category.class);
        category.setId(id);
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public void deleteCategory(int id) {

        if (!categoryRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id: " + id);
        }

        try {
            categoryRepo.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}

