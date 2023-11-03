package com.miu.lab3restfullwebservice.service;

import com.miu.lab3restfullwebservice.dto.ReviewDto;
import com.miu.lab3restfullwebservice.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ReviewService {
    ReviewDto save(ReviewDto reviewDto);

    void deleteById(Integer id);

    ReviewDto findById(Integer id);

    Page<ReviewDto> findByCondition(ReviewDto reviewDto, Pageable pageable);

    ReviewDto update(ReviewDto reviewDto, Integer id);

    List<ReviewDto> findByProductId(Integer productId);
}
