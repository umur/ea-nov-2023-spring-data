package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "products")
@Entity
@Getter
@Setter
public class Product {
    @Id
    // auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int price;
    private int rating;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne
    private Category category;

}
