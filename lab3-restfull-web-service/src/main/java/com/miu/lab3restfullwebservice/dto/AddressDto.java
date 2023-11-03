package com.miu.lab3restfullwebservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.miu.lab3restfullwebservice.entity.Address}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto implements Serializable {
    private Integer id;
    private String street;
    private String zip;
    private String city;
    private UserDto user;
}