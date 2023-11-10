package edu.miu.ea.jpa.repository;

import edu.miu.ea.jpa.model.domain.JPReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPReviewRepository extends JpaRepository<JPReview, Long> {
}
