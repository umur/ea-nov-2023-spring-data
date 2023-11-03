package com.example.lab2.repository;

import com.example.lab2.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review, Integer> {

    List<Review> findAllByProductId(int id);
}
