package com.miu.lab3restfullwebservice.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.validation.annotation.Validated;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    private Double rating;


    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private Set<Review> reviews = new LinkedHashSet<>();

}
