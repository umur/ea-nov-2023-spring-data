package com.example.assignment2springdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.assignment2springdata.models.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements Serializable {
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    private AddressDto address;
}