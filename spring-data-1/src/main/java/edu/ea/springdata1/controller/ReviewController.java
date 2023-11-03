package edu.ea.springdata1.controller;


import edu.ea.springdata1.dto.FullProductDto;
import edu.ea.springdata1.dto.FullReviewDto;
import edu.ea.springdata1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;





    @PutMapping("/{id}")
    FullReviewDto update (@PathVariable Integer id,@RequestBody FullReviewDto fullReviewDto) throws Exception {
        return reviewService.update(id,fullReviewDto);
    }

    @DeleteMapping("/{id}")
    Boolean delete (@PathVariable Integer id ) throws Exception {
        return reviewService.delete(id);
    }


}
