package com.miu.lab3restfullwebservice.repository;

import com.miu.lab3restfullwebservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}