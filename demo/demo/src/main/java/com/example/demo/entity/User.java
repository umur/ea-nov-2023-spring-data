package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}
