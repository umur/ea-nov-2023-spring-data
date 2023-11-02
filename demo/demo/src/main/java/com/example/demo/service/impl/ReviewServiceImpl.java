package com.example.demo.service.impl;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    @Override
    public List<Review> getReviewsByProduct(Long productId) {
        return reviewRepository.findByProduct_Id(productId);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        return reviewOptional.orElse(null);
    }



    public Review createReview(Review review) {
        reviewRepository.save(review);
        return review;
    }

    @Override
    public Review updateReview(long id, Review updatedReview) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review existingReview = reviewOptional.get();
            // Update user properties with values from updatedUser
            existingReview.setComment(updatedReview.getComment());
            existingReview.setUser(updatedReview.getUser());
            existingReview.setProduct(updatedReview.getProduct());

            reviewRepository.save(existingReview);
        }
        return updatedReview;
    }

    @Override
    public void deleteReview(long id) {
        reviewRepository.deleteById(id);
    }
}
