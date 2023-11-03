package com.example.assignment2springdata.services;

import com.example.assignment2springdata.dto.AddressDto;
import com.example.assignment2springdata.models.Address;

import java.util.List;

public interface AddressService {
    void create(Address address);

    List<Address> findAll();

    void update(AddressDto address, Long id);

    Address getAddress(Long id);

    void delete(Long address);
}