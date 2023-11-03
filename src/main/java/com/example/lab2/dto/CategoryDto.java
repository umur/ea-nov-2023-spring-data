package com.example.lab2.dto;

import com.example.lab2.entity.Product;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private int id;
    private String name;
//    private List<Product> products;
}
