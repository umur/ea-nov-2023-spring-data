package com.spring.SpringData.repository;

import com.spring.SpringData.domain.entities.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category, Integer> {
}
