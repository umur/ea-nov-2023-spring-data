package edu.miu.ea.jpa.service;

import edu.miu.ea.jpa.model.dto.JPReviewDTO;

import java.util.List;

public interface JPReviewService {

    JPReviewDTO addReview(Long productId, Long userId, JPReviewDTO reviewDTO) throws Exception;

    List<JPReviewDTO> findAllByProductId(Long productId) throws Exception;

    List<JPReviewDTO> findAllByUserId(Long userId) throws Exception;

    JPReviewDTO update(Long id, JPReviewDTO reviewDTO) throws Exception;

    boolean retire(Long id) throws Exception;

}
