package com.assignemnts.assignment2.service;

import com.assignemnts.assignment2.dto.get.GetFullCategoryDto;
import com.assignemnts.assignment2.dto.post.PostFullCategoryDto;

import java.util.List;

public interface CategoryService {

    List<GetFullCategoryDto> findAll();

    GetFullCategoryDto findById(Long id);

    GetFullCategoryDto save(PostFullCategoryDto fullCategoryDto);

    GetFullCategoryDto update(PostFullCategoryDto fullCategoryDto, Long id);

    GetFullCategoryDto delete(Long id);
}
