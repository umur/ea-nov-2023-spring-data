package ea.lab3.lab3.controller;

import ea.lab3.lab3.entity.Review;
import ea.lab3.lab3.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewRepository reviewRepository;
    @GetMapping("/byProduct/{productId}")
    public List<Review> findByProduct_Id(@PathVariable int productId){
        return reviewRepository.findByProduct_Id(productId);
    }

}
