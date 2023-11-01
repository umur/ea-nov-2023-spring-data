package com.ea.dataone.service.impl;

import com.ea.dataone.service.AddressService;
import com.ea.dataone.entity.Address;
import com.ea.dataone.repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {


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
    public void delete(Address address) {
        addressRepo.delete(address);
    }
}
