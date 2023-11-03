package edu.ea.springdata1.repository;

import edu.ea.springdata1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo  extends JpaRepository<Category,Integer> {
}
