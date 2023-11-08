package com.example.labspringdata.Service.impl;

import com.example.labspringdata.Service.CategoryService;
import com.example.labspringdata.entity.Category;
import com.example.labspringdata.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getById(int id) {
        Category existingCategory = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return existingCategory;
    }

    @Override
    public Category Save(Category category) {
        categoryRepo.save(category);
        return category;
    }

    @Override
    public void delete(int id) {
        categoryRepo.delete(getById(id));
    }

    @Override
    public Category update(int id, Category category) {
        Category existingCategory=getById(id);
        BeanUtils.copyProperties(category,existingCategory);
        categoryRepo.save(existingCategory);
        return existingCategory;
    }
}
