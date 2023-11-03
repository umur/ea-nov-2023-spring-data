package com.miu.edu.student.negi.Lab3.service;

import com.miu.edu.student.negi.Lab3.model.Address;
import com.miu.edu.student.negi.Lab3.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public List<Address> getAllAddress() {
      return   (List<Address>) addressRepository.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElseThrow(()->new RuntimeException("""
                No address with id:${id} exists."""));
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(int id, Address address) {
        if(addressRepository.existsById(id)){
            address.setId(id);
            return addressRepository.save(address);

        }throw new RuntimeException("""
                NO available address to update""");

    }

    @Override
    public void deleteAddress(int id) {
         addressRepository.deleteById(id);
    }
}
