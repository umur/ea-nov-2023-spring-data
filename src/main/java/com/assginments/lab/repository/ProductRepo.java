package com.assginments.lab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assginments.lab.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Integer> {

    // Find all products that cost more than minPrice.
    List<Product> findByPriceMoreThan(double minPrice);

    // Find all products in cat category and cost less than maxPrice.
    List<Product> findByCategoryIdAndLessThan(int categoryId, double minPrice);

    // Find all products that contain keyword in the name.
    List<Product> findByNameContaining(String keyword);

}
