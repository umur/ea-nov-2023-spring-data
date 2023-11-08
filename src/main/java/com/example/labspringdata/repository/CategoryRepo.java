package com.example.labspringdata.repository;

import com.example.labspringdata.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepo extends ListCrudRepository<Category,Integer> {
}
