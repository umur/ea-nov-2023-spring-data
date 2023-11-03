package com.miu.lab3restfullwebservice.service.impl;

import com.miu.lab3restfullwebservice.common.Converter;
import com.miu.lab3restfullwebservice.dto.ReviewDto;
import com.miu.lab3restfullwebservice.entity.Product;
import com.miu.lab3restfullwebservice.entity.Review;
import com.miu.lab3restfullwebservice.exceptions.ResourceNotFoundException;
import com.miu.lab3restfullwebservice.repository.ReviewRepository;
import com.miu.lab3restfullwebservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final Converter converter;


    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        Review entity = converter.convert(reviewDto, Review.class);
        return converter.convert(repository.save(entity), ReviewDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ReviewDto findById(Integer id) {
        return converter.convert(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new), ReviewDto.class);
    }

    @Override
    public Page<ReviewDto> findByCondition(ReviewDto reviewDto, Pageable pageable) {
        Page<Review> entityPage = repository.findAll(pageable);
        List<Review> entities = entityPage.getContent();
        return new PageImpl<>(converter.convertList(entities, ReviewDto.class), pageable, entityPage.getTotalElements());
    }

    @Override
    public ReviewDto update(ReviewDto reviewDto, Integer id) {
        Optional<Review> data = repository.findById(id);
        Review updatedEntity = data.map(entity -> converter.convert(reviewDto, Review.class)).orElseThrow(ResourceNotFoundException::new);
        return save(converter.convert(updatedEntity, ReviewDto.class));
    }

    @Override
    public List<ReviewDto> findByProductId(Integer productId) {
        return converter.convertList(repository.findAllByProductId(productId), ReviewDto.class);
    }
}
