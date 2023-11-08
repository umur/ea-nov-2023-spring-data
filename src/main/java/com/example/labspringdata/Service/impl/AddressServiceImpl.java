package com.example.labspringdata.Service.impl;

import com.example.labspringdata.Service.AddressService;
import com.example.labspringdata.entity.Address;
import com.example.labspringdata.repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    @Override
    public List<Address> getAll() {
        return addressRepo.findAll();
    }

    @Override
    public Address getById(int id) {
        Optional<Address> OAddress= addressRepo.findById(id);
        if(OAddress.isPresent()){
            return OAddress.get();
        }
        throw new RuntimeException("no address for this id");
    }

    @Override
    public Address Save(Address address) {
            addressRepo.save(address);
        return address;
    }

    @Override
    public void delete(int id) {
        Optional<Address> OAddress= addressRepo.findById(id);
        if(OAddress.isPresent()){
            addressRepo.delete(OAddress.get());
        }
        throw new RuntimeException("no address for this id");
    }

    @Override
    public Address update(int id, Address address) {
        Address existingAddress = addressRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
            BeanUtils.copyProperties(address,existingAddress);
            addressRepo.save(existingAddress);

            return existingAddress;

    }
}
