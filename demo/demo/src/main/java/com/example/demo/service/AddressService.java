package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    public List<Address> getAllAddresses();

    public Address getAddressById(long id);
    public Address createAddress(Address address);

    public Address updateAddress(long id, Address address);

    public void deleteAddress(long id);
}
