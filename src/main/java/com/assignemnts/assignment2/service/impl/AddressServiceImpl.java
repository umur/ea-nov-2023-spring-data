package com.assignemnts.assignment2.service.impl;

import com.assignemnts.assignment2.dto.get.GetFullAddressDto;
import com.assignemnts.assignment2.dto.post.PostFullAddressDto;
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
    public List<GetFullAddressDto> findAll() {
        return addressRepo.findAll().stream()
                .map(address -> modelMapper.map(address, GetFullAddressDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetFullAddressDto findById(long id) {
        return modelMapper.map(addressRepo.findById(id), GetFullAddressDto.class);
    }

    @Override
    public GetFullAddressDto save(PostFullAddressDto fullAddressDto) {
        Address saved = addressRepo.save(modelMapper.map(fullAddressDto, Address.class));
        return modelMapper.map(saved, GetFullAddressDto.class);
    }

    @Override
    public GetFullAddressDto update(PostFullAddressDto fullAddressDto, long id) {
        Address currentAddress = addressRepo.findById(id).orElseThrow();
        currentAddress.setCity(fullAddressDto.getCity());
        currentAddress.setZip(fullAddressDto.getZip());
        currentAddress.setStreet(fullAddressDto.getStreet());
        addressRepo.save(currentAddress);
        return modelMapper.map(currentAddress, GetFullAddressDto.class);
    }

    @Override
    public GetFullAddressDto delete(long id) {
        Address deleteAddress = addressRepo.findById(id).orElseThrow();
        //GetFullAddressDto res = modelMapper.map(deleteAddress, GetFullAddressDto.class);
        addressRepo.delete(deleteAddress);
        return null;
    }
}
