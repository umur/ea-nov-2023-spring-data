package com.assignemnts.assignment2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    String street;
    String zip;
    String city;

    @OneToOne(mappedBy = "address")
    User user;
}
