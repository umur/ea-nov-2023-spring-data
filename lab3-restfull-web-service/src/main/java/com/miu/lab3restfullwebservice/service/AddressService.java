package com.miu.lab3restfullwebservice.service;

import com.miu.lab3restfullwebservice.dto.AddressDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {
    AddressDto save(AddressDto addressDto);

    void deleteById(Integer id);

    AddressDto findById(Integer id);

    Page<AddressDto> findByCondition(AddressDto addressDto, Pageable pageable);

    AddressDto update(AddressDto addressDto, Integer id);
}
