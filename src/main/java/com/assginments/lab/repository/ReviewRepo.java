package com.assginments.lab.repository;

import org.springframework.data.repository.CrudRepository;

import com.assginments.lab.entity.Review;

public interface ReviewRepo extends CrudRepository<Review, Integer> {

}