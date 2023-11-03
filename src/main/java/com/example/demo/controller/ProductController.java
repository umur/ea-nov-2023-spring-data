package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    final ProductService productService;

    @GetMapping()
    public List<ProductDto> findAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping()
    public ProductDto create(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable int id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/minPrice/{minPrice}")
    public List<ProductDto> findByMinPrice(@PathVariable int minPrice) {
        return productService.getProductsByMinPrice(minPrice);
    }

    @GetMapping("/category/{id}")
    public List<ProductDto> findByCategoryId(@PathVariable int id, @RequestParam int maxPrice) {
        return productService.getProductsByCategoryIdAndMaxPrice(id, maxPrice);
    }

    @GetMapping("/keyword")
    public List<ProductDto> findByKeyword(@RequestParam String keyword) {
        return productService.getProductsByKeyword(keyword);
    }
}
