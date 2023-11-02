package com.assginments.lab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.assginments.lab.dto.ProductDto;
import com.assginments.lab.entity.Product;
import com.assginments.lab.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepo ProductRepo;
    private final ModelMapper mapper;

    // findAll
    public List<ProductDto> findAll() {
        var products = ProductRepo.findAll();
        List<ProductDto> result = mapper.map(products, new TypeToken<List<ProductDto>>() {
        }.getType());
        return result;
    }

    // findById
    public ProductDto findById(int id) {
        return mapper.map(ProductRepo.findById(id), ProductDto.class);
    }

    // Add
    public void add(ProductDto newAddress) {
        var address = mapper.map(newAddress, Product.class);
        ProductRepo.save(address);
    }

    // update
    public void update(int id, ProductDto updatedProductDto) {

    }

    // remove
    public void remove(int id) {
        ProductRepo.deleteById(id);
    }

    @Override
    public List<ProductDto> findByPriceMoreThan(double minPrice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPriceMoreThan'");
    }

    @Override
    public List<ProductDto> findByCategoryIdAndPriceLessThan(int categoryId, double minPrice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCategoryIdAndLessThan'");
    }

    @Override
    public List<ProductDto> findByNameContaining(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNameContaining'");
    }
}
