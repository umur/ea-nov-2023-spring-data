package com.miu.edu.student.negi.Lab3.service;

import com.miu.edu.student.negi.Lab3.model.Review;
import com.miu.edu.student.negi.Lab3.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
private final ReviewRepository reviewRepository;
    @Override
    public Review findReviewByProductId(int id) {
        return reviewRepository.findById(id).orElseThrow(()->new RuntimeException("""
                no such review with the given pdoduct  id :${id}"""));
    }

    @Override
    public List<Review> getAllReview() {
        return (List<Review>)reviewRepository.findAll();
    }

    @Override
    public Review findReviewById(int id) {
        return reviewRepository.findById(id).orElseThrow(()->new RuntimeException("""
                no such review with the given review  id :${id}"""));
    }

    @Override
    public void deleteReviewById(int id) {
reviewRepository.deleteById(id);
    }

    @Override
    public Review update(int id, Review review) {
        if(reviewRepository.existsById(id)){
            review.setId(id);
            return reviewRepository.save(review);
        }throw new RuntimeException("""
                nothing to update""");
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}
