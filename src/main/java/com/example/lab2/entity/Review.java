package com.example.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    private int id;
    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;
}
