package com.assignemnts.assignment2.dto.get;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetFullProductDto {
    private Long id;
    private String name;
    private double price;
    private double rating;
    @JsonBackReference
    GetFullCategoryDto category;
    String categoryName;
    @JsonManagedReference
    List<GetFullReviewDto> reviewList;

}
