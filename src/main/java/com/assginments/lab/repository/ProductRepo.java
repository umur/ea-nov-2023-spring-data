package com.assginments.lab.repository;

import org.springframework.data.repository.CrudRepository;

import com.assginments.lab.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Integer> {

}
