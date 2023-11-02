package com.example.lab2.service.impl;

import com.example.lab2.dto.ProductDto;
import com.example.lab2.entity.Product;
import com.example.lab2.repository.ProductRepo;
import com.example.lab2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;



    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepo.findAll();
        var res = new ArrayList<ProductDto>();
        products.forEach(product -> {
            ProductDto productdto = modelMapper.map(product, ProductDto.class);
            res.add(productdto);
        });
        return res;
    }

    @Override
    public ProductDto findById(int id) {
        var product = productRepo.findById(id);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public void deleteById(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public void update(int id, Product product) {
        var product1 = productRepo.findById(id);
        if (product1 != null) {
            productRepo.save(product);
        }
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(Double minPrice) {
        List<Product> products = productRepo.findAllByPriceGreaterThan(minPrice);
        var res = new ArrayList<ProductDto>();
        products.forEach(product -> {
            res.add(modelMapper.map(product, ProductDto.class));
        });
        return res;
    }

    @Override
    public List<ProductDto> findAllByCategoryIdAndPriceLessThan(int categoryId, Double maxPrice) {
       List<Product> products = productRepo.findAllByCategoryIdAndPriceLessThan(categoryId, maxPrice);
        var res = new ArrayList<ProductDto>();
        products.forEach(product -> {
            res.add(modelMapper.map(product, ProductDto.class));
        });
        return res;
    }

    @Override
    public List<ProductDto> findAllByNameContaining(String keyword) {
        List<Product> products = productRepo.findAllByNameContaining(keyword);
        var res = new ArrayList<ProductDto>();
        products.forEach(product -> {
            res.add(modelMapper.map(product, ProductDto.class));
        });
        return res;
    }
}
