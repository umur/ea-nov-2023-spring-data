package com.example.lab2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
//    private List<ReviewDto> reviews;
//    private AddressDto address;
}
