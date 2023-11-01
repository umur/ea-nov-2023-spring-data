package com.ea.dataone.controller;

import com.ea.dataone.entity.Category;
import com.ea.dataone.entity.Product;
import com.ea.dataone.entity.Review;
import com.ea.dataone.service.CategoryService;
import com.ea.dataone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductService reviewService;

    @GetMapping("/findAllByPriceGreaterThan")
    public List<Product> findAllByPriceGreaterThan(@RequestParam int minPrice) {
        return productService.findAllByPriceGreaterThan(minPrice);
    }

        @GetMapping("/findAllProductsInCatCategoryAndLessThanMaxPrice")
    public List<Product> findAllByNameContains(@RequestParam String cat, @RequestParam int maxPrice) {
        Category category = categoryService.findByName(cat);
        return category.getProducts().stream().filter(p -> p.getPrice() < maxPrice).collect(Collectors.toList());
    }

    @GetMapping("/findAllByNameContains")
    public List<Product> findAllByNameContains(@RequestParam String keyword) {
        return productService.findAllByNameContains(keyword);
    }

    @GetMapping("/findAllReviewsByProductId")
    public List<Review> findAllByNameContains(@RequestParam Long id) {
        Product product = productService.getProduct(id);
        return product.getReviews();
    }


}