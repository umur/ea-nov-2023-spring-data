package miu.ea.service.impl;

import miu.ea.entity.Category;
import miu.ea.exception.ResourceNotFoundException;
import miu.ea.payload.CategoryDto;
import miu.ea.repository.CategoryRepository;
import miu.ea.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map((category) -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategoryById(int id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

        categoryRepo.delete(category);

    }

    @Override
    public CategoryDto getCategoryById(int id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

        category.setId(id);
        category.setName(categoryDto.getName());
        //category.setProductList(categoryDto.getProductList());


        Category updatedCategory = categoryRepo.save(category);

        return modelMapper.map(updatedCategory, CategoryDto.class);
    }

} // End of CategoryServiceImpl class
