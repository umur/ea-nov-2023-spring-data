package edu.ea.springdata1.service;

import edu.ea.springdata1.dto.FullCategoryDto;

import java.util.List;

public interface CategoryService {
    List<FullCategoryDto> findAll();
    FullCategoryDto findById(Integer id) throws Exception;
    FullCategoryDto add(FullCategoryDto categoryDto);
    FullCategoryDto update(Integer id,FullCategoryDto categoryDto) throws Exception;
    boolean delete(Integer id) throws Exception;

}
