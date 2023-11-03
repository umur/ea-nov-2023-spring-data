package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.example.demo.entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {

    private int id;
    private String name;
    private int price;
    private int rating;

}
