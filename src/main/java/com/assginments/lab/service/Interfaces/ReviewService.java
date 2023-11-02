package com.assginments.lab.service.Interfaces;

import java.util.List;

import com.assginments.lab.dto.NewReviewDto;
import com.assginments.lab.dto.ReviewDto;

public interface ReviewService {
    // findAll
    List<ReviewDto> findAll();

    // findById
    ReviewDto findById(int id);

    // Add
    void add(NewReviewDto newAddress);

    // update
    void update(int id, ReviewDto updatedReviewDto);

    // remove
    void remove(int id);

    // Find reviews of the product whose id is id.
    List<ReviewDto> findByProductIdEquals(int productId);

    List<ReviewDto> findByUserIdEquals(int userId);
}