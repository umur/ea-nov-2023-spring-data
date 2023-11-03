package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {

    final AddressService addressService;

    @GetMapping()
    public List<AddressDto> findAll() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable int id) {
        return addressService.getAddressById(id);
    }

    @PostMapping()
    public AddressDto create(@RequestBody AddressDto reviewDto) {
        return addressService.addAddress(reviewDto);
    }

    @PutMapping("/{id}")
    public AddressDto update(@PathVariable int id, @RequestBody AddressDto reviewDto) {
        return addressService.updateAddress(id, reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.deleteAddress(id);
    }
}
