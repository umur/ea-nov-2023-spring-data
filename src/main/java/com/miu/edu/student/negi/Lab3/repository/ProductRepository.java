package com.miu.edu.student.negi.Lab3.repository;

import com.miu.edu.student.negi.Lab3.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    List<Product>findProductsByNameContainingIgnoreCase(String name);
    List<Product>findProductsByPriceLessThan(double price);

}
