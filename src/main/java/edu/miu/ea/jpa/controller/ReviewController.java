package edu.miu.ea.jpa.controller;

import edu.miu.ea.jpa.model.dto.JPReviewDTO;
import edu.miu.ea.jpa.service.JPReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private JPReviewService service;

    @PutMapping("/{id}")
    JPReviewDTO update(@PathVariable Long id, @RequestBody JPReviewDTO reviewDTO) throws Exception {
        return service.update(id, reviewDTO);
    }

    @DeleteMapping("/{id}")
    Boolean retire(@PathVariable Long id) throws Exception {
        return service.retire(id);
    }

}
