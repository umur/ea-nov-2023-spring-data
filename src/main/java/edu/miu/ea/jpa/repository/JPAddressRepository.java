package edu.miu.ea.jpa.repository;

import edu.miu.ea.jpa.model.domain.JPAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAddressRepository extends JpaRepository<JPAddress, Long> {
}
