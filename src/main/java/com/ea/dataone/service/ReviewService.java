package com.ea.dataone.service;

import com.ea.dataone.entity.Review;

import java.util.List;

public interface ReviewService {
    void create(Review review);

    List<Review> findAll();

    void update(Review review);

    Review getReview(Long id);

    void delete(Review review);
}
