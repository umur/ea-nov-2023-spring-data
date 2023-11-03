package com.example.lab3.service;

import com.example.lab3.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int productId);
    Product createProduct(Product product);
    Product updateProduct(int productId, Product updateProduct);
    boolean deleteProduct(int productId);

}
