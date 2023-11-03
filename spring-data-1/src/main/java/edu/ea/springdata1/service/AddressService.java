package edu.ea.springdata1.service;

import edu.ea.springdata1.dto.FullAddressDto;

public interface AddressService {


    FullAddressDto  findUserAddress(Integer userId) throws Exception;

    FullAddressDto add(Integer userId,FullAddressDto addressDto) throws Exception;
    FullAddressDto update(Integer addressId,FullAddressDto addressDto) throws Exception;

}
