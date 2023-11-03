package com.miu.lab3restfullwebservice.service.impl;

import com.miu.lab3restfullwebservice.common.Converter;
import com.miu.lab3restfullwebservice.dto.CategoryDto;
import com.miu.lab3restfullwebservice.entity.Category;
import com.miu.lab3restfullwebservice.exceptions.ResourceNotFoundException;
import com.miu.lab3restfullwebservice.repository.CategoryRepository;
import com.miu.lab3restfullwebservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final Converter converter;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category entity = converter.convert(categoryDto, Category.class);
        return converter.convert(repository.save(entity), CategoryDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return converter.convert(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new), CategoryDto.class);
    }

    @Override
    public Page<CategoryDto> findByCondition(CategoryDto categoryDto, Pageable pageable) {
        Page<Category> entityPage = repository.findAll(pageable);
        List<Category> entities = entityPage.getContent();
        return new PageImpl<>(converter.convertList(entities, CategoryDto.class), pageable, entityPage.getTotalElements());
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Integer id) {
        Optional<Category> data = repository.findById(id);
        Category updatedEntity = data.map(entity -> converter.convert(categoryDto, Category.class)).orElseThrow(ResourceNotFoundException::new);
        return save(converter.convert(updatedEntity, CategoryDto.class));
    }
}
