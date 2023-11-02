package com.example.assignment2springdata.services;

import com.example.assignment2springdata.models.Review;

import java.util.List;

public interface ReviewService {
    void create(Review review);

    List<Review> findAll();

    void update(Review review);

    Review getReview(Long id);

    void delete(Long id);
}
