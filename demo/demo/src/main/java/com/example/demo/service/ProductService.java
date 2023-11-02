package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     List<Product> getProductsByMinPrice(double minPrice) ;

     List <Product> getProductsByKeyword (String keyWord);

     List <Product> getProductsByCategoryAndMaxPrice(Category category, double maxPrice);

     public List<Product> getAllProducts();

     public Product getProductById(long id);
     public Product createProduct(Product product);

    public Product updateProduct(long id, Product product);

     public void deleteProduct(long id);

}
