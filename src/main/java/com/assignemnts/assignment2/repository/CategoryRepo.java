package com.assignemnts.assignment2.repository;

import com.assignemnts.assignment2.model.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category, Long> {
}
