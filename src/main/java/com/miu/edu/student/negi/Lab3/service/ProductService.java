package com.miu.edu.student.negi.Lab3.service;

import com.miu.edu.student.negi.Lab3.model.Product;

import java.util.List;

public interface ProductService {
    List<Product>findAll();
    Product getProductByID(int id);
    Product addProduct(Product product);
    Product updateProduct(int id,Product product);
    void deleteProduct(int id);
    List<Product>findByNameContainingIgnoreCase(String name);
    List<Product>findByPriceGreaterThan(double price);


}
