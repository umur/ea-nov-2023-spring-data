package com.example.labspringdata.Service;

import com.example.labspringdata.entity.Category;


import java.util.List;

public interface CategoryService {
    public List<Category> getAll();
    public Category getById(int id);
    public Category Save(Category category);

    public void delete(int id);
    public Category update(int id, Category category);
}
