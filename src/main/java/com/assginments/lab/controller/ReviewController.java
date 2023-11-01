package com.assginments.lab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assginments.lab.dto.ReviewDto;
import com.assginments.lab.service.ReviewService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    // findAll
    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    // findById
    @GetMapping("{id}")
    public ReviewDto findByid(@PathVariable int id) {
        return reviewService.findById(id);
    }

    // Add
    @PostMapping
    public void addNew(@RequestBody ReviewDto reviewDto) {
        reviewService.add(reviewDto);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody ReviewDto reviewDto) {
        reviewService.update(id, reviewDto);
    }

    // remove
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        reviewService.remove(id);
    }

    // Find reviews of the product whose id is id.
    @GetMapping("filter")
    List<ReviewDto> findByReviewIdEquals(int reviewId) {
        return reviewService.findByReviewIdEquals(reviewId);
    }
}
