package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.Review;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private  final ProductService productService;
    private  final CategoryService categoryService;

    // Implement CRUD operations for Product
    @GetMapping("/by-price/{minPrice}")
    public List<Product> getProductsByMinPrice(@PathVariable double minPrice) {
        return productService.getProductsByMinPrice(minPrice);
    }

    @GetMapping("/by-category-and-price/{categoryName}/{maxPrice}")
    public List<Product> getProductsByCategoryAndMaxPrice(
            @PathVariable String categoryName,
            @PathVariable double maxPrice
    ) {
        // Retrieve the Category entity based on the categoryName, e.g., by calling a service method
        Category category = categoryService.findByName(categoryName);

        // Use the category to filter products
        return productService.getProductsByCategoryAndMaxPrice(category, maxPrice);
    }

    @GetMapping("/by-keyword/{keyword}")
    public List<Product> getProductsByKeyword(@PathVariable String keyword) {
        return productService.getProductsByKeyword(keyword);
    }


    @GetMapping
    public List<Product> getAllUProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}