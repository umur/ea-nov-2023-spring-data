package com.spring.SpringData.service;


import com.spring.SpringData.domain.dto.AddressDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> getAllAddresses();

    AddressDto getAddressById(int id);

    AddressDto addAddress(AddressDto addressDto);

    AddressDto updateAddress(int id, AddressDto addressDto);

    void deleteAddress(int id);

}
