package com.example.lab3.service.impl;

import com.example.lab3.Entity.Product;
import com.example.lab3.repository.ProductRepository;
import com.example.lab3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int productId){
        Optional<Product>product=productRepository.findById(productId);
        return product.orElse(null);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(int productId, Product updateProduct){
        Optional<Product> existingProduct=productRepository.findById(productId);
        if (existingProduct.isPresent()){
            Product product=existingProduct.get();
            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            product.setRating(updateProduct.getRating());
            product.setCategory(updateProduct.getCategory());
            return  productRepository.save(product);
        }
        else return null;

    }

    public boolean deleteProduct(int productId){
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }

}
