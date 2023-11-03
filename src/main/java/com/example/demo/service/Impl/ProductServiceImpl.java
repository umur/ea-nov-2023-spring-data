package com.example.demo.service.Impl;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepo.findAll().forEach(product -> {
            productDtoList.add(modelMapper.map(product, ProductDto.class));
        });
        return productDtoList;
    }

    @Override
    public ProductDto getProductById(int id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product.setId(null);
        Product savedProduct = productRepo.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {

        if (!productRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id);
        }

        Product product = modelMapper.map(productDto, Product.class);
        product.setId(id);

        Product savedProduct = productRepo.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public void deleteProduct(int id) {
        if (!productRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id);
        }
        productRepo.deleteById(id);
    }

    @Override
    public List<ProductDto> getProductsByMinPrice(int minPrice) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepo.findAllByPriceGreaterThan(minPrice).forEach(product -> {
            productDtoList.add(modelMapper.map(product, ProductDto.class));
        });
        return productDtoList;
    }

    @Override
    public List<ProductDto> getProductsByCategoryIdAndMaxPrice(int id, int maxPrice) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepo.findAllByCategoryIdAndPriceLessThan(id, maxPrice).forEach(product -> {
            productDtoList.add(modelMapper.map(product, ProductDto.class));
        });
        return productDtoList;
    }

    @Override
    public List<ProductDto> getProductsByKeyword(String keyword) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepo.findAllByNameContaining(keyword).forEach(product -> {
            productDtoList.add(modelMapper.map(product, ProductDto.class));
        });
        return productDtoList;
    }
}

