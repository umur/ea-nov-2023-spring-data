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
}
