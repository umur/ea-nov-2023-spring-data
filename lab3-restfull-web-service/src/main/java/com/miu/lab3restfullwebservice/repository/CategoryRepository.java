package com.miu.lab3restfullwebservice.repository;

import com.miu.lab3restfullwebservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}