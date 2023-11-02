package com.assignemnts.assignment2.service.impl;

import com.assignemnts.assignment2.dto.FullCategoryDto;
import com.assignemnts.assignment2.model.Category;
import com.assignemnts.assignment2.repository.CategoryRepo;
import com.assignemnts.assignment2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<FullCategoryDto> findAll() {
        return categoryRepo.findAll().stream()
                .map(category -> modelMapper.map(category, FullCategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FullCategoryDto findById(Long id) {
        return modelMapper.map(categoryRepo.findById(id), FullCategoryDto.class);
    }

    @Override
    public FullCategoryDto save(FullCategoryDto fullCategoryDto) {
        Category saved = categoryRepo.save(modelMapper.map(fullCategoryDto, Category.class));
        return modelMapper.map(saved, FullCategoryDto.class);
    }

    @Override
    public FullCategoryDto update(FullCategoryDto fullCategoryDto, Long id) {
        Category currentCategory = categoryRepo.findById(id).orElseThrow();
        currentCategory.setName(fullCategoryDto.getName());
        categoryRepo.save(currentCategory);
        return modelMapper.map(currentCategory, FullCategoryDto.class);
    }

    @Override
    public FullCategoryDto delete(Long id) {
        Category deleteCategory = categoryRepo.findById(id).orElseThrow();
        categoryRepo.delete(deleteCategory);
        return modelMapper.map(deleteCategory, FullCategoryDto.class);
    }
}
