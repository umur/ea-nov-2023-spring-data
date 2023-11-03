package com.example.lab2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    private int id;
    private String name;

    @JoinColumn(name = "category_id")
    @OneToMany
    private List<Product> products;

}
