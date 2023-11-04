package com.assignemnts.assignment2.dto.post;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostFullProductDto {
    private String name;
    private double price;
    private double rating;
    private PostFullCategoryDto category;
    private List<PostFullReviewDto> reviewList;

}
