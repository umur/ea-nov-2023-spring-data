package com.example.assignment2springdata.controllers;

import com.example.assignment2springdata.models.Product;
import com.example.assignment2springdata.services.ProductService;
import com.example.assignment2springdata.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void saveProduct(@RequestBody Product product){
        productService.create(product);

    }
    @GetMapping
    public List<Product> getProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProducts(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody Product product,  @PathVariable Long id){
        productService.update(product,id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }

    @GetMapping("/filter")
    public List<Product> getMinPriceProducts(@RequestParam double min){
        return productService.minPriceThen(min);
    }

    @GetMapping("/filters")
    public List<Product> getMaxThanPriceAndProductsWithCategory(@RequestParam double max, String category){
        System.out.println("max: "+ max);
        return productService.maxThanPriceAndProductsWithCategory(max, category);
    }

    @GetMapping("/filters/byName")
    public List<Product> getProductContainName(@RequestParam String prodName){
        return productService.getFindAllByNameContains(prodName);
    }

}
