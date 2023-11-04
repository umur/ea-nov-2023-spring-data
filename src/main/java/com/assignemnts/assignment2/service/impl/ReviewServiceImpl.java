package com.assignemnts.assignment2.service.impl;

import com.assignemnts.assignment2.dto.get.GetFullReviewDto;
import com.assignemnts.assignment2.dto.post.PostFullReviewDto;
import com.assignemnts.assignment2.model.Product;
import com.assignemnts.assignment2.model.Review;
import com.assignemnts.assignment2.model.User;
import com.assignemnts.assignment2.repository.ReviewRepo;
import com.assignemnts.assignment2.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<GetFullReviewDto> findAll() {
        return reviewRepo.findAll().stream()
                .map(review -> modelMapper.map(review, GetFullReviewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetFullReviewDto findById(Long id) {
        return modelMapper.map(reviewRepo.findById(id), GetFullReviewDto.class);
    }

    @Override
    public List<GetFullReviewDto> findAllByProductId(Long productId) {
        return reviewRepo.findAllByProduct_Id(productId).stream()
                .map(r -> modelMapper.map(r, GetFullReviewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetFullReviewDto save(PostFullReviewDto fullReviewDto) {
        Review saved = reviewRepo.save(modelMapper.map(fullReviewDto, Review.class));
        return modelMapper.map(saved, GetFullReviewDto.class);
    }

    @Override
    public GetFullReviewDto update(PostFullReviewDto fullReviewDto, Long id) {
        Review currentReview = reviewRepo.findById(id).orElseThrow();
        currentReview.setComment(fullReviewDto.getComment());
        if (fullReviewDto.getUser() != null)
            currentReview.setUser(modelMapper.map(fullReviewDto.getUser(), User.class));
        if (fullReviewDto.getProduct() != null)
            currentReview.setProduct(modelMapper.map(fullReviewDto.getProduct(), Product.class));
        reviewRepo.save(currentReview);
        return modelMapper.map(currentReview, GetFullReviewDto.class);
    }

    @Override
    public GetFullReviewDto delete(Long id) {
        Review deleteReview = reviewRepo.findById(id).orElseThrow();
        //GetFullReviewDto res = modelMapper.map(deleteReview, GetFullReviewDto.class);
        reviewRepo.delete(deleteReview);
        return null;
    }

}
