package com.example.assignment2springdata.services.impl;

import com.example.assignment2springdata.models.Address;
import com.example.assignment2springdata.repository.AddressRepo;
import com.example.assignment2springdata.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressServiceImp implements AddressService {


    private final AddressRepo addressRepo;

    public void create(Address address) {
        addressRepo.save(address);
    }

    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    @Override
    public void update(Address address) {
        addressRepo.save(address);
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Long id) {
        addressRepo.deleteById(id);
    }
}