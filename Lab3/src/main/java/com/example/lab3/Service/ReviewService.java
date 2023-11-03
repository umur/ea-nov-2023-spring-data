package com.example.lab3.Service;

import com.example.lab3.Model.Review;

public interface ReviewService {
    Review findById(int id);
    Review saveReview(Review review);
    Review updateReview(int id,Review review);
    void deleteReview(int id);
}
