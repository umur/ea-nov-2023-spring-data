package com.miu.edu.student.negi.Lab3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
@Table(name="customer")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(insertable = false, updatable = false)
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String passWord;
    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;
    @Embedded
    private Address address;
}
