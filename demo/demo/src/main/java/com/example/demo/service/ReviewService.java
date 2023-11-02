package com.example.demo.service;


import com.example.demo.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> getReviewsByProduct(Long productId);
    public List<Review> getAllReviews();

    public Review getReviewById(long id);

    public Review createReview(Review review);

    public Review updateReview(long id, Review updatedReview);

    public void deleteReview(long id);
}
