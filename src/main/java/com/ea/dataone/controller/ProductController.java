package com.ea.dataone.controller;

import com.ea.dataone.entity.Product;
import com.ea.dataone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public void create(@RequestBody Product product) {
        productService.create(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PutMapping
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        productService.delete(product);
    }
}