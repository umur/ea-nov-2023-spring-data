package com.miu.edu.student.negi.Lab3.controller;

import com.miu.edu.student.negi.Lab3.model.Product;
import com.miu.edu.student.negi.Lab3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProductByID(id);

    }
    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct( @PathVariable int id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }
    @GetMapping("/name")
    public List<Product> findByNameContainingIgnoreCase(@RequestParam String name) {
        return productService.findByNameContainingIgnoreCase(name);
    }
    @GetMapping("/price")
    public List<Product>findByPriceGreaterThan(double price){
        return productService.findByPriceGreaterThan(price);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable  int id){
         productService.deleteProduct(id);
    }

}
