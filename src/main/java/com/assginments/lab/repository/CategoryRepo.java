package com.assginments.lab.repository;

import org.springframework.data.repository.CrudRepository;

import com.assginments.lab.entity.Category;

public interface CategoryRepo extends CrudRepository<Category, Integer> {

}
