package com.miu.edu.student.negi.Lab3.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter

public class Address  {

    private int id;
    private String city;
    private  String zip;
    private String street;


}
