package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Integer> {

    List<Product> findAllByPriceGreaterThan(int minPrice);

    List<Product> findAllByCategoryIdAndPriceLessThan(int categoryId, int maxPrice);

    List<Product> findAllByNameContaining(String keyword);

}