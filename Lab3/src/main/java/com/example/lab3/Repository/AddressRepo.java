package com.example.lab3.Repository;

import com.example.lab3.Model.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends ListCrudRepository<Address,Integer> {

}
