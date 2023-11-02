package com.assignemnts.assignment2.service.impl;

import com.assignemnts.assignment2.dto.FullProductDto;
import com.assignemnts.assignment2.model.Product;
import com.assignemnts.assignment2.repository.ProductRepo;
import com.assignemnts.assignment2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<FullProductDto> findAll() {
        return productRepo.findAll().stream()
                .map(product -> modelMapper.map(product, FullProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FullProductDto findById(Long id) {
        return modelMapper.map(productRepo.findById(id), FullProductDto.class);
    }

    @Override
    public List<FullProductDto> searchByMinPrice(Double minPrice) {
        return productRepo.findAllByPriceGreaterThan(minPrice).stream()
                .map(p -> modelMapper.map(p, FullProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FullProductDto> searchByCatAndMaxPrice(String cat, double maxPrice) {
        return productRepo.findAllByCategory_NameAndPriceLessThan(cat, maxPrice).stream()
                .map(p -> modelMapper.map(p, FullProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FullProductDto> searchByNameContains(String keyword) {
        return productRepo.findAllByNameContaining(keyword).stream()
                .map(p -> modelMapper.map(p, FullProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FullProductDto save(FullProductDto fullProductDto) {
        Product saved = productRepo.save(modelMapper.map(fullProductDto, Product.class));
        return modelMapper.map(saved, FullProductDto.class);
    }

    @Override
    public FullProductDto update(FullProductDto fullProductDto, Long id) {
        Product currentProduct = productRepo.findById(id).orElseThrow();
        currentProduct.setName(fullProductDto.getName());
        currentProduct.setPrice(fullProductDto.getPrice());
        currentProduct.setRating(fullProductDto.getRating());
        productRepo.save(currentProduct);
        return modelMapper.map(currentProduct, FullProductDto.class);
    }

    @Override
    public FullProductDto delete(Long id) {
        Product deleteProduct = productRepo.findById(id).orElseThrow();
        productRepo.delete(deleteProduct);
        return modelMapper.map(deleteProduct, FullProductDto.class);
    }

}
