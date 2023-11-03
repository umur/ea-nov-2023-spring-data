package edu.ea.springdata1.repository;

import edu.ea.springdata1.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
}
