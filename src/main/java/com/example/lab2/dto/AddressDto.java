package com.example.lab2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private int id;
    private String street;
    private String city;
    private String zip;
//    private UserDto user;
}
