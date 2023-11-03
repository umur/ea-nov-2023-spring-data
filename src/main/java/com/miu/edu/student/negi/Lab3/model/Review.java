package com.miu.edu.student.negi.Lab3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;

    @ManyToOne
    @JoinColumn
    private Product product;
    @ManyToOne
    @JoinColumn
    private  User customer;
}
