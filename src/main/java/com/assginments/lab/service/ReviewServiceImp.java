package com.assginments.lab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.assginments.lab.dto.NewReviewDto;
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
        if (!reviewRepo.existsById(id)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return mapper.map(reviewRepo.findById(id), ReviewDto.class);
    }

    // Add
    public void add(NewReviewDto newReview) {
        var review = mapper.map(newReview, Review.class);
        // review.getUser().setId(newReview);;

        reviewRepo.save(review);
    }

    // update
    public void update(int id, ReviewDto updatedReviewDto) {
        var review = reviewRepo.findById(id);
        if (review.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        review.get().setComment(updatedReviewDto.getComment());

        reviewRepo.save(review.get());

    }

    // remove
    public void remove(int id) {
        if (!reviewRepo.existsById(id)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        reviewRepo.deleteById(id);
    }

    @Override
    public List<ReviewDto> findByProductIdEquals(int productId) {
        var reviews = reviewRepo.findByProductId(productId);

        List<ReviewDto> result = mapper.map(reviews, new TypeToken<List<ReviewDto>>() {
        }.getType());
        return result;
    }

    @Override
    public List<ReviewDto> findByUserIdEquals(int userId) {
        var reviews = reviewRepo.findByUserId(userId);

        List<ReviewDto> result = mapper.map(reviews, new TypeToken<List<ReviewDto>>() {
        }.getType());
        return result;
    }

}