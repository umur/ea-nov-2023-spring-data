package com.example.lab2.service;

import com.example.lab2.dto.ProductDto;
import com.example.lab2.entity.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);
    List<ProductDto> findAll();
    ProductDto findById(int id);
    void deleteById(int id);
    void update(int id,Product product);
    List<ProductDto> findAllByPriceGreaterThan(Double minPrice);
    List<ProductDto> findAllByCategoryIdAndPriceLessThan(int categoryId, Double maxPrice);
    List<ProductDto> findAllByNameContaining(String keyword);
}
