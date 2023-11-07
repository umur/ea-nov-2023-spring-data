package com.miu.edu.student.negi.Lab3.service;

import com.miu.edu.student.negi.Lab3.aspects.CustomAnnotation;
import com.miu.edu.student.negi.Lab3.model.Product;
import com.miu.edu.student.negi.Lab3.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return( List<Product>)productRepository.findAll();
    }

    @Override
    public Product getProductByID(int id) {
        return productRepository.findById(id).orElseThrow();
//        ()->new RuntimeException("""
//               NO available product with this id:${id}""")
    }

    @Override
    @CustomAnnotation
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        if(productRepository.existsById(id)){
            product.setId(id);
            return productRepository.save(product);
        }throw new RuntimeException("""
                nothing to update""");
    }

    @Override
    public void deleteProduct(int id) {

        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> findByPriceGreaterThan(double price) {
        return productRepository.findByPriceGreaterThan(price);
    }






}





