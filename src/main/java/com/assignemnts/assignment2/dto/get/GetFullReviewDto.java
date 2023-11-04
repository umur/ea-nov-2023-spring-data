package com.assignemnts.assignment2.dto.get;

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
public class GetFullReviewDto implements Serializable {
    private Long id;
    private String comment;
    @JsonBackReference
    private GetFullProductDto product;
    @JsonBackReference
    private GetFullUserDto user;

}
