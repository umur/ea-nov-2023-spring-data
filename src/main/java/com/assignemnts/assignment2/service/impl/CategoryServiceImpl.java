package com.assignemnts.assignment2.service.impl;

import com.assignemnts.assignment2.dto.get.GetFullCategoryDto;
import com.assignemnts.assignment2.dto.post.PostFullCategoryDto;
import com.assignemnts.assignment2.model.Category;
import com.assignemnts.assignment2.model.Product;
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
    public List<GetFullCategoryDto> findAll() {
        return categoryRepo.findAll().stream()
                .map(category -> modelMapper.map(category, GetFullCategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetFullCategoryDto findById(Long id) {
        return modelMapper.map(categoryRepo.findById(id), GetFullCategoryDto.class);
    }

    @Override
    public GetFullCategoryDto save(PostFullCategoryDto fullCategoryDto) {
        Category saved = categoryRepo.save(modelMapper.map(fullCategoryDto, Category.class));
        return modelMapper.map(saved, GetFullCategoryDto.class);
    }

    @Override
    public GetFullCategoryDto update(PostFullCategoryDto fullCategoryDto, Long id) {
        Category currentCategory = categoryRepo.findById(id).orElseThrow();
        currentCategory.setName(fullCategoryDto.getName());
        currentCategory.setProductList(fullCategoryDto.getProductList().stream()
                .map(p -> modelMapper.map(p, Product.class))
                .collect(Collectors.toList()));
        categoryRepo.save(currentCategory);
        return modelMapper.map(currentCategory, GetFullCategoryDto.class);
    }

    @Override
    public GetFullCategoryDto delete(Long id) {
        Category deleteCategory = categoryRepo.findById(id).orElseThrow();
        //GetFullCategoryDto res = modelMapper.map(deleteCategory, GetFullCategoryDto.class);
        categoryRepo.delete(deleteCategory);
        return null;
    }
}
