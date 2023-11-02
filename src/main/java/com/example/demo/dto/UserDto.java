package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;


    @JsonIgnore
    private AddressDto address;

}
