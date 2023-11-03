package com.miu.lab3restfullwebservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastname;

    @OneToOne(mappedBy = "user", optional = false, orphanRemoval = true)
    private Address address;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Review> reviews = new LinkedHashSet<>();

}
