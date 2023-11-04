package com.assignemnts.assignment2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    Category category;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    List<Review> reviewList;
}
