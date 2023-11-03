package com.example.lab2.dto;

import com.example.lab2.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private int id;
    private String comment;
//    private UserDto userId;
//    private ProductDto productId;
}
