package com.example.labspringdata.repository;

import com.example.labspringdata.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepo extends ListCrudRepository<Review,Integer> {
    public List<Review> findByProductId(Integer id);
}
