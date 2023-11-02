package com.example.demo.service.Impl;


import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<AddressDto> getAllAddresses() {
        List<AddressDto> addressDtoList = new ArrayList<>();
        addressRepo.findAll().forEach(address -> {
            addressDtoList.add(modelMapper.map(address, AddressDto.class));
        });
        return addressDtoList;
    }

    @Override
    public AddressDto getAddressById(int id) {
        Address address = addressRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id: " + id));
        return modelMapper.map(address, AddressDto.class);
    }

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        address.setId(null);
        Address savedAddress = addressRepo.save(address);
        return modelMapper.map(savedAddress, AddressDto.class);
    }

    @Override
    public AddressDto updateAddress(int id, AddressDto addressDto) {
            if (!addressRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id: " + id);
            }
            Address address = modelMapper.map(addressDto, Address.class);
            address.setId(id);
            Address savedAddress = addressRepo.save(address);
            return modelMapper.map(savedAddress, AddressDto.class);
    }

    @Override
    public void deleteAddress(int id) {
        if (!addressRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id: " + id);
        }
        addressRepo.deleteById(id);
    }
}

