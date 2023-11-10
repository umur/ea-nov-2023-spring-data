package edu.miu.ea.jpa.repository;

import edu.miu.ea.jpa.model.domain.JPCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPCategoryRepository extends JpaRepository<JPCategory, Long> {
}
