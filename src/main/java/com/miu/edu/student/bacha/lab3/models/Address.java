package com.miu.edu.student.bacha.lab3.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {
    private int id;
    private String street;
    private String city;
    private String zip;
}
