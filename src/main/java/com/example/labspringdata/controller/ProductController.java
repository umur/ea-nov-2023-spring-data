package com.example.labspringdata.controller;

import com.example.labspringdata.Service.ProductService;
import com.example.labspringdata.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public List<Product> getAll()
    {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id)
    {
        return  productService.getById(id);
    }
    @PostMapping
    public Product save(@RequestBody Product product)
    {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id , @RequestBody Product product)
    {
        return  productService.update(id,product);
    }
}
