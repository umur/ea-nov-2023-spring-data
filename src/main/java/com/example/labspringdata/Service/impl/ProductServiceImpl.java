package com.example.labspringdata.Service.impl;

import com.example.labspringdata.Service.ProductService;
import com.example.labspringdata.entity.Category;
import com.example.labspringdata.entity.Product;
import com.example.labspringdata.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(int id) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return existingProduct;
    }

    @Override
    public Product save(Product product) {
        productRepo.save(product);
        return product;
    }


    @Override
    public void delete(int id) {
        productRepo.delete(getById(id));
    }

    @Override
    public Product update(int id, Product product) {
        Product existingProduct=getById(id);
        BeanUtils.copyProperties(product,existingProduct);
        productRepo.save(existingProduct);
        return existingProduct;
    }


}
