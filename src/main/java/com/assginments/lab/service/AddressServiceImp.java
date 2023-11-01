package com.assginments.lab.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.assginments.lab.dto.AddressDto;
import com.assginments.lab.entity.Address;
import com.assginments.lab.repository.AddressRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AddressServiceImp implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper mapper;

    // findAll
    public List<AddressDto> findAll() {
        var addresses = addressRepo.findAll();
        List<AddressDto> result = mapper.map(addresses, new TypeToken<List<AddressDto>>() {
        }.getType());
        return result;
    }

    // findById
    public AddressDto findById(int id) {
        return mapper.map(addressRepo.findById(id), AddressDto.class);
    }

    // Add
    public void add(AddressDto newAddress) {
        var address = mapper.map(newAddress, Address.class);
        addressRepo.save(address);
    }

    // update
    public void update(int id, AddressDto updatedAddressDto) {

    }

    // remove
    public void remove(int id) {
        addressRepo.deleteById(id);
    }
}
