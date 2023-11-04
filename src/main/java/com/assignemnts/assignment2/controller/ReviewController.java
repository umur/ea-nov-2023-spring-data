package com.assignemnts.assignment2.controller;

import com.assignemnts.assignment2.dto.get.GetFullReviewDto;
import com.assignemnts.assignment2.dto.post.PostFullReviewDto;
import com.assignemnts.assignment2.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<GetFullReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public GetFullReviewDto findById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @GetMapping("/searchByProductId")
    public List<GetFullReviewDto> searchByProductId(@RequestParam Long productId) {
        return reviewService.findAllByProductId(productId);
    }

    @PostMapping
    public GetFullReviewDto save(@RequestBody PostFullReviewDto fullReviewDto) {
        return reviewService.save(fullReviewDto);
    }

    @PutMapping("/{id}")
    public GetFullReviewDto update(@RequestBody PostFullReviewDto fullReviewDto, @PathVariable Long id) {
        try {
            return reviewService.update(fullReviewDto, id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        }
    }

    @DeleteMapping("/{id}")
    public GetFullReviewDto delete(@PathVariable Long id) {
        try {
            return reviewService.delete(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        }
    }
}
