package com.assginments.lab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewReviewDto {
    private int id;
    private String comment;

    private int userId;
    private int productId;
}
