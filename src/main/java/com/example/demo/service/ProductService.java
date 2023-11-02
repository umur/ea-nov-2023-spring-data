package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(int id);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(int id, ProductDto productDto);

    void deleteProduct(int id);

    List<ProductDto> getProductsByMinPrice(int minPrice);

    List<ProductDto> getProductsByCategoryIdAndMaxPrice(int id, int maxPrice);

    List<ProductDto> getProductsByKeyword(String keyword);
}
