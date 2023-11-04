package com.spring.SpringData.repository;

import com.spring.SpringData.domain.entities.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepo extends ListCrudRepository<Product, Integer> {
}
