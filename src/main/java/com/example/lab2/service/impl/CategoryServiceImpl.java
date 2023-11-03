package com.example.lab2.service.impl;

import com.example.lab2.dto.CategoryDto;
import com.example.lab2.entity.Category;
import com.example.lab2.repository.CategoryRepo;
import com.example.lab2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepo.findAll();
        var result = new ArrayList<CategoryDto>();
        categories.forEach(category -> {
            var categoryDto = modelMapper.map(category, CategoryDto.class);
            result.add(categoryDto);
        });
        return result;
    }

    @Override
    public CategoryDto findById(int id) {
        var category = categoryRepo.findById(id);
        var categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public void deleteById(int id) {
        if (categoryRepo.existsById(id)) {
            categoryRepo.deleteById(id);
        }
    }

    @Override
    public void update(int id, Category category) {
        var categoryEntity = categoryRepo.findById(id);
        if (categoryEntity != null) {
            categoryRepo.save(category);
        }
    }
}
