package com.example.labspringdata.repository;

import com.example.labspringdata.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends ListCrudRepository<Product,Integer> {
    public List<Product> getProductsByPriceGreaterThan(Integer price);
    public List<Product> findByCategoryNameAndPriceLessThan(String category, Integer price);
    public List<Product> findByNameContaining(String name);
}
