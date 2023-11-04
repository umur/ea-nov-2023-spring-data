package com.assignemnts.assignment2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @ManyToOne( fetch = FetchType.LAZY)
    private Product product;
    @ManyToOne(  fetch = FetchType.LAZY)
    private User user;
}
