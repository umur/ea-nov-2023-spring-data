package com.example.lab2.service;


import com.example.lab2.dto.AddressDto;
import com.example.lab2.entity.Address;

import java.util.List;
public interface AddressService {
    void save(Address address);

    List<AddressDto> findAll();
    Address findById(int id);
    void deleteById(int id);

    void update(int id, Address address);
}
