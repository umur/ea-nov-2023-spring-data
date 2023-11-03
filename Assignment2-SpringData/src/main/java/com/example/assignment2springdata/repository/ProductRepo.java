package com.example.assignment2springdata.repository;

import com.example.assignment2springdata.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByNameContainingIgnoreCase(String keyword);
    List<Product> findAllByPriceLessThanAndCategory_NameContainsIgnoreCase(double price, String keyword);
}
