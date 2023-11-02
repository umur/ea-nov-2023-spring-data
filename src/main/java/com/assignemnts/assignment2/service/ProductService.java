package com.assignemnts.assignment2.service;

import com.assignemnts.assignment2.dto.FullProductDto;

import java.util.List;

public interface ProductService {

    List<FullProductDto> findAll();

    FullProductDto findById(Long id);

    List<FullProductDto> searchByMinPrice(Double minPrice);

    List<FullProductDto> searchByCatAndMaxPrice(String cat, double maxPrice);

    List<FullProductDto> searchByNameContains(String keyword);

    FullProductDto save(FullProductDto fullProductDto);

    FullProductDto update(FullProductDto fullProductDto, Long id);

    FullProductDto delete(Long id);

}
