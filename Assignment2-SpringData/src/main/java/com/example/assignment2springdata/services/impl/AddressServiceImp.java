package com.example.assignment2springdata.services.impl;

import com.example.assignment2springdata.dto.AddressDto;
import com.example.assignment2springdata.models.Address;
import com.example.assignment2springdata.repository.AddressRepo;
import com.example.assignment2springdata.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImp implements AddressService {


    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    public void create(Address address) {
        addressRepo.save(address);
    }

    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    @Override
    public void update(AddressDto addressDto, Long id) {
        //Address address = modelMapper.map(addressDto, Address.class);
        //address.setId(id);
        Address address1 = addressRepo.findById(id).get();
        address1.setCity(Optional.ofNullable(addressDto.getCity()).map(v-> v).orElse(""));
        address1.setZip(Optional.ofNullable(addressDto.getZip()).map(v-> v).orElse(""));
        address1.setStreet(Optional.ofNullable(addressDto.getStreet()).map(v-> v).orElse(""));
        addressRepo.save(address1);
//        AddressDto updateStudentDto = modelMapper.map(stu, StudentDto.class);

/*
        Address address2 = addressRepo.save(address);
*/

/*        Address address1 = addressRepo.findById(id).get();
        if (address1 != null) {
            address1.setCity(address.getCity());
            address1.setZip(address.getZip());
            address1.setStreet(address.getStreet());
            addressRepo.save(address1);
        }*/
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