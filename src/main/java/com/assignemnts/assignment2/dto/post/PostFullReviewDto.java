package com.assignemnts.assignment2.dto.post;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostFullReviewDto implements Serializable {
    private String comment;
    private PostFullProductDto product;
    @JsonBackReference
    private PostFullUserDto user;

}
