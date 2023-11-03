package ea.lab3.lab3.service.impl;

import ea.lab3.lab3.dto.ReviewDto;
import ea.lab3.lab3.entity.Review;
import ea.lab3.lab3.repository.ReviewRepository;
import ea.lab3.lab3.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ReviewDto> findReviewsByProductId(int productId) {
        List<Review> reviewList = reviewRepository.findByProduct_Id(productId);
        List<ReviewDto> results = new ArrayList<>();

        for (Review review : reviewList) {
            ReviewDto reviewDto = modelMapper.map(review, ReviewDto.class);
            results.add(reviewDto);
        }

        return results;
    }
}
