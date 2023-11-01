package com.ea.dataone.service.impl;

import com.ea.dataone.service.ReviewService;
import com.ea.dataone.entity.Review;
import com.ea.dataone.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {


    private final ReviewRepo reviewRepo;

    public void create(Review review) {
        reviewRepo.save(review);
    }

    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public void update(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public Review getReview(Long id) {
        return reviewRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Review review) {
        reviewRepo.delete(review);
    }
}
