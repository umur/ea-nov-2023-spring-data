package com.assginments.lab.repository;

import org.springframework.data.repository.CrudRepository;

import com.assginments.lab.entity.Address;

public interface AddressRepo extends CrudRepository<Address, Integer> {

}
