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
    public void update(Product product, Long id) {
        Product product1 = productRepo.findById(id).get();
        if (product1 != null) {
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setRating(product.getRating());
            productRepo.save(product1);
        }
    }

    @Override
    public Product getProduct(Long id) {
        return productRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> minPriceThen(double price) {
        return productRepo.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> maxThanPriceAndProductsWithCategory(double price, String category) {
        return productRepo.findAllByPriceLessThanAndCategory_NameContainsIgnoreCase(price, category);
    }

    @Override
    public List<Product> getFindAllByNameContains(String name) {
        return productRepo.findAllByNameContainsIgnoreCase(name);
    }

}