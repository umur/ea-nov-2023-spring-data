package com.assignemnts.assignment2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String comment;

    @ManyToOne
    Product product;
    @ManyToOne
    User user;
}
