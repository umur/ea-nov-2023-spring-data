package com.example.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private int id;
    private String name;
    private double price;
    private int rating;

    @ManyToOne
    private Category category;

    @JoinColumn(name = "product_id")
    @OneToMany
    private List<Review> reviews;
}
