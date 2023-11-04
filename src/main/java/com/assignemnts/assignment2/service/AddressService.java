package com.assignemnts.assignment2.service;

import com.assignemnts.assignment2.dto.get.GetFullAddressDto;
import com.assignemnts.assignment2.dto.post.PostFullAddressDto;

import java.util.List;

public interface AddressService {
    List<GetFullAddressDto> findAll();
    GetFullAddressDto findById(long id);

    GetFullAddressDto save(PostFullAddressDto fullAddressDto);

    GetFullAddressDto update(PostFullAddressDto fullAddressDto, long id);

    GetFullAddressDto delete(long id);
}
