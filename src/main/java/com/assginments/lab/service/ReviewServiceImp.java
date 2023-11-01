package com.assginments.lab.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.assginments.lab.dto.ReviewDto;
import com.assginments.lab.entity.Review;
import com.assginments.lab.repository.ReviewRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ModelMapper mapper;

    // findAll
    public List<ReviewDto> findAll() {
        var reviews = reviewRepo.findAll();
        List<ReviewDto> result = mapper.map(reviews, new TypeToken<List<ReviewDto>>() {
        }.getType());
        return result;
    }

    // findById
    public ReviewDto findById(int id) {
        return mapper.map(reviewRepo.findById(id), ReviewDto.class);
    }

    // Add
    public void add(ReviewDto newReview) {
        var Review = mapper.map(newReview, Review.class);
        reviewRepo.save(Review);
    }

    // update
    public void update(int id, ReviewDto updatedReviewDto) {

    }

    // remove
    public void remove(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public List<ReviewDto> findByReviewIdEquals(int reviewId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByReviewIdEquals'");
    }
}