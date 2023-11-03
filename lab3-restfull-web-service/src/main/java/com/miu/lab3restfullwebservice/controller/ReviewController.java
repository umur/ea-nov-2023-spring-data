package com.miu.lab3restfullwebservice.controller;

import com.miu.lab3restfullwebservice.dto.ReviewDto;
import com.miu.lab3restfullwebservice.exceptions.ResourceNotFoundException;
import com.miu.lab3restfullwebservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/review")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReviewDto reviewDto) {
        reviewService.save(reviewDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> findById(@PathVariable("id") Integer id) {
        ReviewDto review = reviewService.findById(id);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(reviewService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reviewService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReviewDto>> pageQuery(ReviewDto reviewDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReviewDto> reviewPage = reviewService.findByCondition(reviewDto, pageable);
        return ResponseEntity.ok(reviewPage);
    }

    @GetMapping("/searchBy/{productId}")
    public ResponseEntity<List<ReviewDto>> searchByProductId(@PathVariable("productId") Integer productId) {
        List<ReviewDto> reviewPage = reviewService.findByProductId(productId);
        return ResponseEntity.ok(reviewPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> update(@RequestBody @Validated ReviewDto reviewDto, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(reviewService.update(reviewDto, id));
    }
}
