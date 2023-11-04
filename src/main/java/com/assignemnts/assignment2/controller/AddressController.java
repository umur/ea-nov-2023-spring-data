package com.assignemnts.assignment2.controller;

import com.assignemnts.assignment2.dto.get.GetFullAddressDto;
import com.assignemnts.assignment2.dto.post.PostFullAddressDto;
import com.assignemnts.assignment2.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;
    @GetMapping
    public List<GetFullAddressDto> findAll(){
        return addressService.findAll();
    }
    @GetMapping("/{id}")
    public GetFullAddressDto findById(@PathVariable Long id){
        return addressService.findById(id);
    }
    @PostMapping
    public GetFullAddressDto save(@RequestBody PostFullAddressDto fullAddressDto){
        return addressService.save(fullAddressDto);
    }
    @PutMapping("/{id}")
    public GetFullAddressDto update(@RequestBody PostFullAddressDto fullAddressDto, @PathVariable Long id){
        try {
            return addressService.update(fullAddressDto, id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
        }
    }
    @DeleteMapping("/{id}")
    public GetFullAddressDto delete(@PathVariable Long id){
        try {
            return addressService.delete(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
        }
    }
}
