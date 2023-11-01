package com.assginments.lab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assginments.lab.dto.ProductDto;
import com.assginments.lab.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prodcuts")
public class ProductController {
    private final ProductService productService;

    // findAll
    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    // findById
    @GetMapping("{id}")
    public ProductDto findByid(@PathVariable int id) {
        return productService.findById(id);
    }

    // Add
    @PostMapping
    public void addNew(@RequestBody ProductDto productDto) {
        productService.add(productDto);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody ProductDto productDto) {
        productService.update(id, productDto);
    }

    // remove
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        productService.remove(id);
    }

    // Find all products that cost more than minPrice.
    @GetMapping("price")
    List<ProductDto> MoreThan(@RequestParam double minPrice) {
        return productService.findByPriceMoreThan(minPrice);
    }

    // Find all products in cat product and cost less than maxPrice.
    @GetMapping("filter-product-price")
    List<ProductDto> findByProductIdAndLessThan(@RequestParam int productId, @RequestParam double minPrice) {
        return productService.findByCategoryIdAndPriceLessThan(productId, minPrice);
    }

    // Find all products that contain keyword in the name.
    @GetMapping("filter")
    List<ProductDto> findByNameContaining(@RequestParam String keyword) {
        return productService.findByNameContaining(keyword);
    }
}
