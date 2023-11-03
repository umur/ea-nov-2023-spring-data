package com.miu.lab3restfullwebservice.service;

import com.miu.lab3restfullwebservice.dto.ProductDto;
import com.miu.lab3restfullwebservice.entity.Category;
import com.miu.lab3restfullwebservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto productDto);

    void deleteById(Integer id);

    ProductDto findById(Integer id);

    Page<ProductDto> findByCondition(ProductDto productDto, Pageable pageable);

    ProductDto update(ProductDto productDto, Integer id);
    List<ProductDto> findByPriceGreaterThan(Double minPrice);
    List<ProductDto> findByCategoryAndPriceGreaterThan(Integer categoryId, Double minPrice);
    List<ProductDto> findByNameContains(String keyword);
}
