package com.example.lab3.Service;


import com.example.lab3.Model.Product;

public interface ProductService {
    Product findById(int id);
    Product saveProduct(Product product);
    Product updateProduct(int id,Product product);
    void deleteProduct(int id);

}

