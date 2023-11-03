package ea.lab3.lab3.service;

import ea.lab3.lab3.dto.ReviewDto;
import ea.lab3.lab3.entity.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findReviewsByProductId(int productId);
}
