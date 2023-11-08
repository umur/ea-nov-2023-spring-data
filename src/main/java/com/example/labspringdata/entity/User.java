package com.example.labspringdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    private int id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Review> createdReviews;

    @OneToOne
    private Address address;
}
