package com.ea.dataone.service;

import com.ea.dataone.entity.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);

    List<Product> findAll();

    void update(Product product);

    Product getProduct(Long id);

    void delete(Product product);

    List<Product> findAllByPriceGreaterThan(int minPrice);

    List<Product> findAllByNameContains(String keyword);
}
