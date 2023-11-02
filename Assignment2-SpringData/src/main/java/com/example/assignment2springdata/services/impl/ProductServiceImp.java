package com.example.assignment2springdata.services.impl;

import com.example.assignment2springdata.models.Product;
import com.example.assignment2springdata.repository.ProductRepo;
import com.example.assignment2springdata.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {


    private final ProductRepo productRepo;

    public void create(Product product) {
        productRepo.save(product);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void update(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

}