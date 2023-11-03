package com.example.assignment2springdata;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Assignment2SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Assignment2SpringDataApplication.class, args);
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
