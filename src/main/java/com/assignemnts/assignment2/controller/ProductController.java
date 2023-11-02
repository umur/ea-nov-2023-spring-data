package com.assignemnts.assignment2.controller;

import com.assignemnts.assignment2.dto.FullProductDto;
import com.assignemnts.assignment2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<FullProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public FullProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }
    @GetMapping("/searchByMinPrice")
    public List<FullProductDto> searchByMinPrice(@RequestParam Double minPrice) {
        return productService.searchByMinPrice(minPrice);
    }

    @GetMapping("/searchByCatAndMaxPrice")
    public List<FullProductDto> searchByCatAndMaxPrice(@RequestParam String cat, @RequestParam double maxPrice) {
        return productService.searchByCatAndMaxPrice(cat, maxPrice);
    }

    @GetMapping("/searchByNameContains")
    public List<FullProductDto> searchByNameContains(@RequestParam String keyword) {
        return productService.searchByNameContains(keyword);
    }

    @PostMapping
    public FullProductDto save(@RequestBody FullProductDto fullProductDto) {
        return productService.save(fullProductDto);
    }

    @PutMapping("/{id}")
    public FullProductDto update(@RequestBody FullProductDto fullProductDto, @PathVariable Long id) {
        try {
            return productService.update(fullProductDto, id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @DeleteMapping("/{id}")
    public FullProductDto delete(@PathVariable Long id) {
        try {
            return productService.delete(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }
}
