package com.example.labspringdata.controller;

import com.example.labspringdata.Service.ReviewService;
import com.example.labspringdata.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<Review> getAll()
    {
        return reviewService.getAll();
    }
    @GetMapping("/{id}")
    public Review getById(@PathVariable int id)
    {
        return  reviewService.getById(id);
    }
    @PostMapping
    public Review save(@RequestBody Review review)
    {
        return reviewService.Save(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        reviewService.delete(id);
    }

    @PutMapping("/{id}")
    public Review update(@PathVariable int id , @RequestBody Review review)
    {
        return  reviewService.update(id,review);
    }

}
