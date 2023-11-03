package com.miu.lab3restfullwebservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link com.miu.lab3restfullwebservice.entity.Category}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDto implements Serializable {
    private Integer id;
    private String name;
    private Set<ProductDto> products = new LinkedHashSet<>();
}