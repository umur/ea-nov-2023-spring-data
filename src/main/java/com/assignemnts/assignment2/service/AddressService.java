package com.assignemnts.assignment2.service;

import com.assignemnts.assignment2.dto.FullAddressDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface AddressService {
    List<FullAddressDto> findAll();
    FullAddressDto findById(long id);

    FullAddressDto save(FullAddressDto fullAddressDto);

    FullAddressDto update(FullAddressDto fullAddressDto, long id);

    FullAddressDto delete(long id);
}
