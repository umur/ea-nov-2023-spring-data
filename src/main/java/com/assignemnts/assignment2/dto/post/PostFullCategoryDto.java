package com.assignemnts.assignment2.dto.post;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostFullCategoryDto {
    private String name;
    private List<PostFullProductDto> productList;
}
