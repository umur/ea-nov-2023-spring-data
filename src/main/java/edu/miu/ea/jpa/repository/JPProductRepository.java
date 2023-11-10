package edu.miu.ea.jpa.repository;

import edu.miu.ea.jpa.model.domain.JPProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPProductRepository extends JpaRepository<JPProduct, Long> {
}
