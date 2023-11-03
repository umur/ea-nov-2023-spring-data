package miu.ea.service;

import miu.ea.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();
}
