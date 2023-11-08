package com.example.labspringdata.Service;

import com.example.labspringdata.Service.impl.ReviewServiceImpl;
import com.example.labspringdata.entity.Review;

import java.util.List;

public interface ReviewService {
    public List<Review> getAll();
    public Review getById(int id);
    public Review Save(Review review);

    public void delete(int id);
    public Review update(int id, Review review);
}
