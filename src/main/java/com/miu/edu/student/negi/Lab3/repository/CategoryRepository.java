package com.miu.edu.student.negi.Lab3.repository;

import com.miu.edu.student.negi.Lab3.model.Category;
import com.miu.edu.student.negi.Lab3.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
    List<Product>findAllProductsByCategoryAndPriceLessThan(Category category,double price);
}
