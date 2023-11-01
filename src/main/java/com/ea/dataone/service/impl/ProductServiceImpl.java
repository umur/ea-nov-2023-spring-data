package com.ea.dataone.service.impl;

import com.ea.dataone.service.ProductService;
import com.ea.dataone.entity.Product;
import com.ea.dataone.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {


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
    public void delete(Product product) {
        productRepo.delete(product);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(int minPrice) {
        return productRepo.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findAllByNameContains(String keyword) {
        return productRepo.findAllByNameContains(keyword);
    }
}
