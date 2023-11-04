package com.assignemnts.assignment2.service;

import com.assignemnts.assignment2.dto.get.GetFullReviewDto;
import com.assignemnts.assignment2.dto.post.PostFullReviewDto;

import java.util.List;

public interface ReviewService {
    List<GetFullReviewDto> findAll();

    GetFullReviewDto findById(Long id);
    List<GetFullReviewDto> findAllByProductId(Long productId);

    GetFullReviewDto save(PostFullReviewDto fullReviewDto);
    GetFullReviewDto update(PostFullReviewDto fullReviewDto, Long id);
    GetFullReviewDto delete(Long id);


}
