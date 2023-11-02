package com.assignemnts.assignment2.repository;

import com.assignemnts.assignment2.model.Product;
import com.assignemnts.assignment2.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface  ProductRepo extends ListCrudRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(double minPrice);
    List<Product> findAllByCategory_NameAndPriceLessThan(String cat, double maxPrice);
    List<Product> findAllByNameContaining(String keyword);

}
