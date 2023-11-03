package com.example.assignment2springdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.assignment2springdata.models.Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto implements Serializable {
    private long id;
    private String name;
    private double price;
    private double rating;
    private CategoryDto category;
    private List<ReviewDto> reviews;
}