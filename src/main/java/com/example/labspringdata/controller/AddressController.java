package com.example.labspringdata.controller;

import com.example.labspringdata.Service.AddressService;
import com.example.labspringdata.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<Address> getAll()
    {
        return addressService.getAll();
    }
    @GetMapping("/{id}")
    public Address getById(@PathVariable int id)
    {
        return  addressService.getById(id);
    }
    @PostMapping
    public Address save(@RequestBody Address address)
    {
        return addressService.Save(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        addressService.delete(id);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable int id , @RequestBody Address address)
    {
        return  addressService.update(id,address);
    }
}
