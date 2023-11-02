package com.assginments.lab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.assginments.lab.dto.CategoryDto;
import com.assginments.lab.entity.Category;
import com.assginments.lab.repository.CategoryRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper mapper;

    // findAll
    public List<CategoryDto> findAll() {
        var categories = categoryRepo.findAll();
        List<CategoryDto> result = mapper.map(categories, new TypeToken<List<Category>>() {
        }.getType());
        return result;
    }

    // findById
    public CategoryDto findById(int id) {
        return mapper.map(categoryRepo.findById(id), CategoryDto.class);
    }

    // Add
    public void add(CategoryDto newCategory) {
        var Category = mapper.map(newCategory, Category.class);
        categoryRepo.save(Category);
    }

    // update
    public void update(int id, CategoryDto updatedCategoryDto) {

    }

    // remove
    public void remove(int id) {
        categoryRepo.deleteById(id);
    }
}
