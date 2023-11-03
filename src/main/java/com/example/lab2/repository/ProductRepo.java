package com.example.lab2.repository;

import com.example.lab2.entity.Category;
import com.example.lab2.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Integer> {

    List<Product> findAllByPriceGreaterThan(Double minPrice);

    List<Product> findAllByCategoryIdAndPriceLessThan(int categoryId, Double maxPrice);

    List<Product> findAllByNameContaining(String keyword);
}
