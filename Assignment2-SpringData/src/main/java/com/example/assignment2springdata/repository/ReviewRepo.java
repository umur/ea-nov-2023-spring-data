package com.example.assignment2springdata.repository;

import com.example.assignment2springdata.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
