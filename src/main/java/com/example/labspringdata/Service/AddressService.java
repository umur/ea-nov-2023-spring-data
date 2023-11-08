package com.example.labspringdata.Service;

import com.example.labspringdata.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAll();
    public Address getById(int id);
    public Address Save(Address address);

    public void delete(int id);
    public Address update(int id, Address address);
}
