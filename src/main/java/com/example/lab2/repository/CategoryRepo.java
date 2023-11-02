package com.example.lab2.repository;

import com.example.lab2.entity.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category, Integer> {

}
