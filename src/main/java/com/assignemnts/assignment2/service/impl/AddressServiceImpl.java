package com.assignemnts.assignment2.service.impl;

import com.assignemnts.assignment2.dto.FullAddressDto;
import com.assignemnts.assignment2.model.Address;
import com.assignemnts.assignment2.repository.AddressRepo;
import com.assignemnts.assignment2.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<FullAddressDto> findAll() {
        return addressRepo.findAll().stream()
                .map(address -> modelMapper.map(address, FullAddressDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FullAddressDto findById(long id) {
        return modelMapper.map(addressRepo.findById(id), FullAddressDto.class);
    }

    @Override
    public FullAddressDto save(FullAddressDto fullAddressDto) {
        Address saved = addressRepo.save(modelMapper.map(fullAddressDto, Address.class));
        return modelMapper.map(saved, FullAddressDto.class);
    }

    @Override
    public FullAddressDto update(FullAddressDto fullAddressDto, long id) {
        Address currentAddress = addressRepo.findById(id).orElseThrow();
        currentAddress.setCity(fullAddressDto.getCity());
        currentAddress.setZip(fullAddressDto.getZip());
        currentAddress.setStreet(fullAddressDto.getStreet());
        addressRepo.save(currentAddress);
        return modelMapper.map(currentAddress, FullAddressDto.class);
    }

    @Override
    public FullAddressDto delete(long id) {
        Address deleteAddress = addressRepo.findById(id).orElseThrow();
        addressRepo.delete(deleteAddress);
        return modelMapper.map(deleteAddress, FullAddressDto.class);
    }
}
