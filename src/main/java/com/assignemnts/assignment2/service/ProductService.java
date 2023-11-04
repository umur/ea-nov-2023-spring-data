package com.assignemnts.assignment2.service;

import com.assignemnts.assignment2.dto.get.GetFullProductDto;
import com.assignemnts.assignment2.dto.post.PostFullProductDto;

import java.util.List;

public interface ProductService {

    List<GetFullProductDto> findAll();

    GetFullProductDto findById(Long id);

    List<GetFullProductDto> searchByMinPrice(Double minPrice);

    List<GetFullProductDto> searchByCatAndMaxPrice(String cat, double maxPrice);

    List<GetFullProductDto> searchByNameContains(String keyword);

    GetFullProductDto save(PostFullProductDto fullProductDto);

    GetFullProductDto update(PostFullProductDto fullProductDto, Long id);

    GetFullProductDto delete(Long id);

}
