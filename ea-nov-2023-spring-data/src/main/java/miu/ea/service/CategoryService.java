package miu.ea.service;

import miu.ea.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    public List<CategoryDto> findAllCategories();

    void deleteCategoryById(int id);

    public CategoryDto getCategoryById(int id);
    public CategoryDto updateCategory(CategoryDto categoryDto, int id);
}
