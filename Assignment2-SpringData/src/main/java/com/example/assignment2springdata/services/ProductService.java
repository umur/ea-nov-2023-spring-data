package com.example.assignment2springdata.services;

import com.example.assignment2springdata.models.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);

    List<Product> findAll();

    void update(Product product , Long id);

    Product getProduct(Long id);

    void delete(Long id);

    List<Product> minPriceThen(double price);
    List<Product> maxThanPriceAndProductsWithCategory(double price, String category);

    public List<Product> getFindAllByNameContains(String name);
}
