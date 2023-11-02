package com.assignemnts.assignment2.repository;

import com.assignemnts.assignment2.model.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends ListCrudRepository<Address, Long> {
}
