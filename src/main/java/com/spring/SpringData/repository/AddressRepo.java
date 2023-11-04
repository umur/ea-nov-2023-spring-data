package com.spring.SpringData.repository;

import com.spring.SpringData.domain.entities.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends ListCrudRepository<Address, Integer> {
}
