package com.assignemnts.assignment2.service;

import com.assignemnts.assignment2.dto.FullCategoryDto;

import java.util.List;

public interface CategoryService {

    List<FullCategoryDto> findAll();

    FullCategoryDto findById(Long id);

    FullCategoryDto save(FullCategoryDto fullCategoryDto);

    FullCategoryDto update(FullCategoryDto fullCategoryDto, Long id);

    FullCategoryDto delete(Long id);
}
