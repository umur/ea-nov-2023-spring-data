package com.example.demo.service.impl;

import com.example.demo.entity.Address;
import com.example.demo.entity.Category;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
private final AddressRepository addressRepository;
    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        return addressOptional.orElse(null);
    }

    @Override
    public Address createAddress(Address address) {
        addressRepository.save(address);
        return address;
    }

    @Override
    public Address updateAddress(long id, Address updatedAddress) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (addressOptional.isPresent()) {
            Address existingAddress = addressOptional.get();
            // Update user properties with values from updatedUser
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setZip(updatedAddress.getZip());
            existingAddress.setStreet(updatedAddress.getStreet());
            existingAddress.setUser(updatedAddress.getUser());
        }
        return updatedAddress;
    }

    @Override
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }

}