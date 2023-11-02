package com.example.lab2.service;

import com.example.lab2.dto.ReviewDto;
import com.example.lab2.entity.Review;
import java.util.List;
public interface ReviewService {
    void save(Review review);
    List<ReviewDto> findAll();
    Review findById(int id);
    void deleteById(int id);
    void update(int id, Review review);
    List<ReviewDto> findAllByProductId(int productId);
}
