package com.example.labspringdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
