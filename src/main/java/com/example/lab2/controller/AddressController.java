package com.example.lab2.controller;

import com.example.lab2.dto.AddressDto;
import com.example.lab2.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.lab2.service.AddressService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> getAllAddresses() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable int id) {
        return addressService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteById(id);
    }

    @PostMapping
    public void saveAddress(@RequestBody Address address) {
        addressService.save(address);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable int id, @RequestBody Address address) {
        addressService.update(id, address);
    }

}
