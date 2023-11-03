package com.example.lab3.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Address {

    private String street;
    private Long zip;
    private String city;

}
