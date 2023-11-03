package com.miu.lab3restfullwebservice.service;

import com.miu.lab3restfullwebservice.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);

    void deleteById(Integer id);

    CategoryDto findById(Integer id);

    Page<CategoryDto> findByCondition(CategoryDto categoryDto, Pageable pageable);

    CategoryDto update(CategoryDto categoryDto, Integer id);
}
