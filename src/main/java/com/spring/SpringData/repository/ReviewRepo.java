package com.spring.SpringData.repository;

import com.spring.SpringData.domain.entities.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review, Integer> {
}
