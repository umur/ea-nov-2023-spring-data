package com.example.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    private int id;
    private String street;
    private String city;
    private String zip;


    @OneToOne
    private User user;
}
