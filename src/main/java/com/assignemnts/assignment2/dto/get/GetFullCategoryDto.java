package com.assignemnts.assignment2.dto.get;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetFullCategoryDto {
    private Long id;
    private String name;
    @JsonManagedReference
    private List<GetFullProductDto> productList;
}
