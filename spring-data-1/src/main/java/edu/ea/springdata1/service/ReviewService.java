package edu.ea.springdata1.service;


import edu.ea.springdata1.dto.FullReviewDto;

import java.util.List;

public interface ReviewService {


     List<FullReviewDto> findAllByProductId(Integer productId) throws Exception;
    List<FullReviewDto> findAllByUserId(Integer userId) throws Exception;
    FullReviewDto update(Integer id, FullReviewDto fullReviewDto) throws Exception;
    boolean delete(Integer id) throws Exception;
    FullReviewDto addReview(Integer productId,Integer userId,FullReviewDto fullReviewDto) throws Exception;
}
