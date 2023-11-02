package com.assginments.lab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.assginments.lab.dto.CategoryDto;
import com.assginments.lab.dto.NewCategoryDto;
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
        List<CategoryDto> result = mapper.map(categories, new TypeToken<List<CategoryDto>>() {
        }.getType());
        return result;
    }

    // findById
    public CategoryDto findById(int id) {
        return mapper.map(categoryRepo.findById(id), CategoryDto.class);
    }

    // Add
    public void add(NewCategoryDto newCategory) {
        var category = mapper.map(newCategory, Category.class);
        categoryRepo.save(category);
    }

    // update
    public void update(int id, NewCategoryDto updatedCategoryDto) {
        var category = mapper.map(updatedCategoryDto, Category.class);
        category.setId(id);
        categoryRepo.save(category);
    }

    // remove
    public void remove(int id) {
        categoryRepo.deleteById(id);
    }
}
