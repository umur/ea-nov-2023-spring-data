package com.example.assignment2springdata.services.impl;

import com.example.assignment2springdata.models.Review;
import com.example.assignment2springdata.models.User;
import com.example.assignment2springdata.repository.ReviewRepo;
import com.example.assignment2springdata.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepo reviewRepo;
    @Override
    public void create(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public void update(Review review, Long id) {
        Review review1 = reviewRepo.findById(id).get();
        if(review1!=null){
            review1.setComment(review.getComment());
            reviewRepo.save(review1);
        }
        reviewRepo.save(review);
    }

    @Override
    public Review getReview(Long id) {
        return reviewRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }
}
