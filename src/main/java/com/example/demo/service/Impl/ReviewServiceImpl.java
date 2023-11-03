package com.example.demo.service.Impl;


import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ReviewDto> getAllReviews() {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        reviewRepo.findAll().forEach(review -> {
            reviewDtoList.add(modelMapper.map(review, ReviewDto.class));
        });
        return reviewDtoList;
    }

    @Override
    public ReviewDto getReviewById(int id) {
        Review review = reviewRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found with id: " + id));
        return modelMapper.map(review, ReviewDto.class);
    }

    @Override
    public ReviewDto addReview(ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        Review savedReview = reviewRepo.save(review);
        review.setId(null);
        return modelMapper.map(savedReview, ReviewDto.class);
    }

    @Override
    public ReviewDto updateReview(int id, ReviewDto reviewDto) {
        if (!reviewRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found with id: " + id);
        }
        Review review = modelMapper.map(reviewDto, Review.class);
        review.setId(id);
        Review savedReview = reviewRepo.save(review);
        return modelMapper.map(savedReview, ReviewDto.class);
    }

    @Override
    public void deleteReview(int id) {
        if (!reviewRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found with id: " + id);
        }
        reviewRepo.deleteById(id);
    }

    @Override
    public List<ReviewDto> getReviewsByProductId(int id) {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        reviewRepo.findByProductId(id).forEach(review -> {
            reviewDtoList.add(modelMapper.map(review, ReviewDto.class));
        });
        return reviewDtoList;
    }
}

