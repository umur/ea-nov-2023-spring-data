package com.miu.edu.student.negi.Lab3.service;

import com.miu.edu.student.negi.Lab3.model.Review;

import java.util.List;

public interface ReviewService {
    Review findReviewByProductId(int id);
    List<Review> getAllReview();
    Review findReviewById(int id);
    void deleteReviewById(int id);
    Review update(int id,Review review);
}
