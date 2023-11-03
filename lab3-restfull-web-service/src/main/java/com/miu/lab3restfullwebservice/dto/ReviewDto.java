package com.miu.lab3restfullwebservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.miu.lab3restfullwebservice.entity.Review}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewDto implements Serializable {
    private Integer id;
    private String review;
    private ProductDto product;
    private UserDto user;
}