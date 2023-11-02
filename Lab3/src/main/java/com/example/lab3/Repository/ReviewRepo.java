package com.example.lab3.Repository;

import com.example.lab3.Model.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review,Integer> {
}
