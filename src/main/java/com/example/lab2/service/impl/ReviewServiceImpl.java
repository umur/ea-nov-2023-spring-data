package com.example.lab2.service.impl;

import com.example.lab2.dto.ReviewDto;
import com.example.lab2.entity.Review;
import com.example.lab2.repository.ReviewRepo;
import com.example.lab2.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;
    @Override
    public void save(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public List<ReviewDto> findAll() {
        List<Review> reviews = reviewRepo.findAll();
        var res = new ArrayList<ReviewDto>();
        reviews.forEach(review -> {
            ReviewDto reviewdto = modelMapper.map(review, ReviewDto.class);
            res.add(reviewdto);
        });
        return res;
    }

    @Override
    public Review findById(int id) {
        var review = reviewRepo.findById(id);
        return modelMapper.map(review, Review.class);
    }

    @Override
    public void deleteById(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public void update(int id, Review review) {
        var review1 = reviewRepo.findById(id);
        if (review1 != null) {
            reviewRepo.save(review);
        }
    }

    @Override
    public List<ReviewDto> findAllByProductId(int productId) {
        List<Review> reviews = reviewRepo.findAllByProductId(productId);
        var res = new ArrayList<ReviewDto>();
        reviews.forEach(review -> {
            ReviewDto reviewdto = modelMapper.map(review, ReviewDto.class);
            res.add(reviewdto);
        });
        return res;
    }
}
