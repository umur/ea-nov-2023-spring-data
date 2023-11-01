package com.assginments.lab.service;

import java.util.List;

import com.assginments.lab.dto.ProductDto;

public interface ProductService {
    // findAll
    List<ProductDto> findAll();

    // findById
    ProductDto findById(int id);

    // Add
    void add(ProductDto newAddress);

    // update
    void update(int id, ProductDto updatedProductDto);

    // remove
    void remove(int id);

    // Find all products that cost more than minPrice.
    List<ProductDto> findByPriceMoreThan(double minPrice);

    // Find all products in cat category and cost less than maxPrice.
    List<ProductDto> findByCategoryIdAndPriceLessThan(int categoryId, double minPrice);

    // Find all products that contain keyword in the name.
    List<ProductDto> findByNameContaining(String keyword);
}
