package com.example.lab3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Address {
    @Id
    private int id;
    private String street;
    private Long zip;
    private String city;

}
