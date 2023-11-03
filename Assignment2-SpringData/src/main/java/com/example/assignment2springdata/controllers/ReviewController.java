package com.example.assignment2springdata.controllers;

import com.example.assignment2springdata.dto.AddressDto;
import com.example.assignment2springdata.models.Address;
import com.example.assignment2springdata.models.Review;
import com.example.assignment2springdata.services.AddressService;
import com.example.assignment2springdata.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public void saveAddress(@RequestBody Review review){
        reviewService.create(review);
    }

    @PutMapping("/{id}")
    public void updateAddress(@RequestBody Review review, @PathVariable Long id){
        reviewService.update(review, id);
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable Long id){
        return reviewService.getReview(id);
    }


    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id){
        reviewService.delete(id);
    }
}
