package miu.ea.service.impl;

import miu.ea.payload.CategoryDto;
import miu.ea.repository.CategoryRepository;
import miu.ea.service.CategoryService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;
    private final ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepo, ModelMapper mapper) {
        this.categoryRepo = categoryRepo;
        this.mapper = mapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        return null;
    }

    @Override
    public void deleteCategoryById(int id) {

    }

    @Override
    public CategoryDto getCategoryById(int id) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
        return null;
    }

} // End of CategoryServiceImpl class
