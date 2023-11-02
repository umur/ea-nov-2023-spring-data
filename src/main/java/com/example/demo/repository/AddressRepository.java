package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ListCrudRepository<Address, Integer> {


}