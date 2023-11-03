package com.example.lab2.controller;

import com.example.lab2.aspect.ExecutionTime;
import com.example.lab2.dto.ProductDto;
import com.example.lab2.entity.Category;
import com.example.lab2.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.lab2.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ProductDto getProductById(@PathVariable int id) {
        return productService.findById(id);
    }

    @GetMapping("/minPrice")
    public List<ProductDto> getProductsByMinPrice(@RequestParam double minPrice) {
        return productService.findAllByPriceGreaterThan(minPrice);
    }

    @GetMapping("/{categoryId}/maxPrice")
    public List<ProductDto> getProductsByCategoryIdAndMaxPrice( @PathVariable int categoryId, @RequestParam double maxPrice) {
        return productService.findAllByCategoryIdAndPriceLessThan(categoryId, maxPrice);
    }

    @GetMapping("/keyword")
    public List<ProductDto> getProductsByNameContainingKeyword(@RequestParam String keyword) {
        return productService.findAllByNameContaining(keyword);
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product productDto) {
        productService.update(id, productDto);
    }



}
