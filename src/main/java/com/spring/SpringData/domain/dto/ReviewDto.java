package com.spring.SpringData.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {

    private int id;
    private String comment;
    private int rating;

}
