package com.example.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @JoinColumn(name = "user_id")
    @OneToMany
    private List<Review> reviews;

}
