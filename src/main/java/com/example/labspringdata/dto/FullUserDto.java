package com.example.labspringdata.dto;

import com.example.labspringdata.entity.Address;
import com.example.labspringdata.entity.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullUserDto {
    private int id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;
    private List<Review> createdReviews;
    private Address address;


}
