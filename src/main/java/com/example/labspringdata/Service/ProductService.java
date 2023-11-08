package com.example.labspringdata.Service;

import com.example.labspringdata.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product getById(int id);
    public Product save(Product product);

    public void delete(int id);
    public Product update(int id, Product product);
}
