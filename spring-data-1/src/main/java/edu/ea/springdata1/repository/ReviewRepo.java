package edu.ea.springdata1.repository;

import edu.ea.springdata1.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo  extends JpaRepository<Review,Integer> {
}
