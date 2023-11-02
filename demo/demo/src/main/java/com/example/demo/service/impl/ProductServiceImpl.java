package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProductsByMinPrice(double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getProductsByKeyword(String keyWord) {
        return productRepository.findByNameContaining(keyWord);
    }


    @Override
    public List<Product> getProductsByCategoryAndMaxPrice(Category category, double maxPrice) {
        return productRepository.findByCategoryAndPriceLessThan(category, maxPrice);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(long id, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            // Update user properties with values from updatedUser
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setRating(updatedProduct.getRating());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setReviews(updatedProduct.getReviews());

            productRepository.save(existingProduct);
        }
        return updatedProduct;
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }


}
