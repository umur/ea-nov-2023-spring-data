package com.example.lab2.service.impl;
import com.example.lab2.dto.AddressDto;
import com.example.lab2.entity.Address;
import com.example.lab2.repository.AddressRepo;
import com.example.lab2.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;
    @Override
    public void save(Address address) {
        addressRepo.save(address);
    }

    @Override
    public List<AddressDto> findAll() {
        List<Address> addresses = addressRepo.findAll();
        var res = new ArrayList<AddressDto>();
        addresses.forEach(address -> res.add(modelMapper.map(address, AddressDto.class)));
        return res;
    }

    @Override
    public Address findById(int id) {
        var address = addressRepo.findById(id);
        return modelMapper.map(address, Address.class);
    }

    @Override
    public void deleteById(int id) {
        addressRepo.deleteById(id);
    }

    @Override
    public void update(int id, Address address) {
        var address1 = addressRepo.findById(id);
        if (address1 != null) {
            addressRepo.save(address);
        }
    }
}
