package com.example.lab3.Repository;

import com.example.lab3.Model.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends ListCrudRepository<Product,Integer> {
    Product findById(int id);

    Product updateById(int id,Product product);
    void deleteById(int id);
}
