package com.miu.lab3restfullwebservice.service.impl;

import com.miu.lab3restfullwebservice.common.Converter;
import com.miu.lab3restfullwebservice.dto.AddressDto;
import com.miu.lab3restfullwebservice.entity.Address;
import com.miu.lab3restfullwebservice.exceptions.ResourceNotFoundException;
import com.miu.lab3restfullwebservice.repository.AddressRepository;
import com.miu.lab3restfullwebservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final Converter converter;

    @Override
    public AddressDto save(AddressDto addressDto) {
        Address entity = converter.convert(addressDto, Address.class);
        return converter.convert(repository.save(entity), AddressDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public AddressDto findById(Integer id) {
        return converter.convert(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new), AddressDto.class);
    }

    @Override
    public Page<AddressDto> findByCondition(AddressDto addressDto, Pageable pageable) {
        Page<Address> entityPage = repository.findAll(pageable);
        List<Address> entities = entityPage.getContent();
        return new PageImpl<>(converter.convertList(entities, AddressDto.class), pageable, entityPage.getTotalElements());
    }

    @Override
    public AddressDto update(AddressDto addressDto, Integer id) {
        Optional<Address> data = repository.findById(id);
        Address updatedEntity = data.map(entity -> converter.convert(addressDto, Address.class)).orElseThrow(ResourceNotFoundException::new);
        return save(converter.convert(updatedEntity, AddressDto.class));
    }
}
