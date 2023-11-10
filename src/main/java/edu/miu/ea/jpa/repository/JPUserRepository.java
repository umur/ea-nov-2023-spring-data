package edu.miu.ea.jpa.repository;

import edu.miu.ea.jpa.model.domain.JPUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPUserRepository extends JpaRepository<JPUser, Long> {
}
