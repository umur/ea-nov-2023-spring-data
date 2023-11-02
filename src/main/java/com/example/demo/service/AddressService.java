package com.example.demo.service;


import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CategoryDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> getAllAddresses();

    AddressDto getAddressById(int id);

    AddressDto addAddress(AddressDto addressDto);

    AddressDto updateAddress(int id, AddressDto addressDto);

    void deleteAddress(int id);

}
