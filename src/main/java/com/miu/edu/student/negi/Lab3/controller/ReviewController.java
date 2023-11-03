package com.miu.edu.student.negi.Lab3.controller;

import com.miu.edu.student.negi.Lab3.model.Review;
import com.miu.edu.student.negi.Lab3.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

   @GetMapping
   public List<Review>getAllReviews(){
        return reviewService.getAllReview();
    }
    @GetMapping("/{id}")
    public Review findReviewByProductId(@PathVariable int id){
       return  reviewService.findReviewByProductId(id);
    }
    @PostMapping("")
    public  Review addReview(@RequestBody Review review){

   return reviewService.addReview(review);
   }
   @DeleteMapping("/{id}")
    public  void deleteById(@PathVariable int id){
       reviewService.deleteReviewById(id);
   }
   @PutMapping("/{id}")
    public  Review updateById(@RequestBody Review review,@PathVariable int id){
       return reviewService.update(id,review);
   }
}
