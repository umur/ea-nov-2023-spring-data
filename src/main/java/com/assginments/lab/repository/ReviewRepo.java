package com.assginments.lab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assginments.lab.entity.Review;

public interface ReviewRepo extends CrudRepository<Review, Integer> {
    // Find reviews of the product whose id is id.
    List<Review> findByReviewIdEquals(int reviewId);
}