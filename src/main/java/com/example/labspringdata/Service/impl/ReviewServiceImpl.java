package com.example.labspringdata.Service.impl;

import com.example.labspringdata.Service.ReviewService;
import com.example.labspringdata.entity.Product;
import com.example.labspringdata.entity.Review;
import com.example.labspringdata.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    @Override
    public List<Review> getAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getById(int id) {
        Review existingReview = reviewRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return existingReview;
    }

    @Override
    public Review Save(Review review) {
        reviewRepo.save(review);
        return review;
    }

    @Override
    public void delete(int id) {
        reviewRepo.delete(getById(id));
    }

    @Override
    public Review update(int id, Review review) {
        Review existingReview=getById(id);
        BeanUtils.copyProperties(review,existingReview,"id");
        reviewRepo.save(existingReview);
        return existingReview;
    }
}
