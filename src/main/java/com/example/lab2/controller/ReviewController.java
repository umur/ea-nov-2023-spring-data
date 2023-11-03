package com.example.lab2.controller;

import com.example.lab2.dto.ReviewDto;
import com.example.lab2.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.lab2.service.ReviewService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable int id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public void saveReview(@RequestBody Review review) {
        reviewService.save(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateReview(@PathVariable int id, @RequestBody Review review) {
        reviewService.update(id, review);
    }
}
