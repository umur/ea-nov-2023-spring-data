package com.miu.edu.student.negi.Lab3.service;

import com.miu.edu.student.negi.Lab3.model.Category;
import com.miu.edu.student.negi.Lab3.model.Product;
import com.miu.edu.student.negi.Lab3.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private  final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("""
                       no category with the given id""")
                );
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }


    @Override
    public Category updateCategory(int id, Category category) {
        if(categoryRepository.existsById(id)){
            category.setId(id);
            categoryRepository.save(category);
        }throw new RuntimeException("""
                nothing to update""");
    }

    @Override
   public void deleteCategoryById(int id) {
categoryRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllproductFromCategory(Category category, double price) {
        return categoryRepository.findAllProductsByCategoryAndPriceLessThan(category, price);
    }


}
