package com.miu.lab3restfullwebservice.service.impl;

import com.miu.lab3restfullwebservice.common.Converter;
import com.miu.lab3restfullwebservice.dto.ProductDto;
import com.miu.lab3restfullwebservice.entity.Category;
import com.miu.lab3restfullwebservice.entity.Product;
import com.miu.lab3restfullwebservice.exceptions.ResourceNotFoundException;
import com.miu.lab3restfullwebservice.repository.CategoryRepository;
import com.miu.lab3restfullwebservice.repository.ProductRepository;
import com.miu.lab3restfullwebservice.service.ProductService;
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
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final Converter converter;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDto save(ProductDto productDto) {
        Product entity = converter.convert(productDto, Product.class);
        return converter.convert(repository.save(entity), ProductDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ProductDto findById(Integer id) {
        return converter.convert(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new), ProductDto.class);
    }

    @Override
    public Page<ProductDto> findByCondition(ProductDto productDto, Pageable pageable) {
        Page<Product> entityPage = repository.findAll(pageable);
        List<Product> entities = entityPage.getContent();
        return new PageImpl<>(converter.convertList(entities, ProductDto.class), pageable, entityPage.getTotalElements());
    }

    @Override
    public ProductDto update(ProductDto productDto, Integer id) {
        Optional<Product> data = repository.findById(id);
        Product updatedEntity = data.map(entity -> converter.convert(productDto, Product.class)).orElseThrow(ResourceNotFoundException::new);
        return save(converter.convert(updatedEntity, ProductDto.class));
    }

    @Override
    public List<ProductDto> findByPriceGreaterThan(Double minPrice) {
        return converter.convertList(repository.findAllByPriceGreaterThan(minPrice), ProductDto.class);
    }

    @Override
    public List<ProductDto> findByCategoryAndPriceGreaterThan(Integer categoryId, Double minPrice) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return converter.convertList(category.map(entity -> repository.findAllByCategoryAndPriceGreaterThan(entity, minPrice))
                .orElseThrow(ResourceNotFoundException::new), ProductDto.class);
    }

    @Override
    public List<ProductDto> findByNameContains(String keyword) {
        return converter.convertList(repository.findAllByNameContains(keyword), ProductDto.class);
    }
}
