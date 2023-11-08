package com.example.labspringdata.repository;

import com.example.labspringdata.entity.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepo extends ListCrudRepository<Address , Integer> {
}
