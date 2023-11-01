package com.assginments.lab.service;

import java.util.List;

import com.assginments.lab.dto.AddressDto;

public interface AddressService {
    // findAll
    List<AddressDto> findAll();

    // findById
    AddressDto findById(int id);

    // Add
    void add(AddressDto newAddress);

    // update
    void update(int id, AddressDto updatedAddressDto);

    // remove
    void remove(int id);
}
