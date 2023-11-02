package com.example.assignment2springdata.services;

import com.example.assignment2springdata.models.Category;
import com.example.assignment2springdata.models.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);

    List<Product> findAll();

    void update(Product product);

    Product getProduct(Long id);

    void delete(Long id);

}
