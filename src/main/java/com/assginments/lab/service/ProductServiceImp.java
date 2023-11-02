package com.assginments.lab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.assginments.lab.dto.NewProductDto;
import com.assginments.lab.dto.ProductDto;
import com.assginments.lab.dto.ProductFilterDto;
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
    public void add(NewProductDto newProdcut) {
        var product = mapper.map(newProdcut, Product.class);
        ProductRepo.save(product);
    }

    // update
    public void update(int id, NewProductDto updatedProductDto) {
        var product = ProductRepo.findById(id);
        if (product.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        product.get().setName(updatedProductDto.getName());
        product.get().setPrice(updatedProductDto.getPrice());
        product.get().setRating(updatedProductDto.getRating());

        ProductRepo.save(product.get());

    }

    // remove
    public void remove(int id) {
        ProductRepo.deleteById(id);
    }

    @Override
    public List<ProductDto> findByPriceMoreThan(double minPrice) {
        var products = ProductRepo.findByPriceGreaterThan(minPrice);
        List<ProductDto> result = mapper.map(products, new TypeToken<List<ProductDto>>() {
        }.getType());
        return result;

    }

    @Override
    public List<ProductDto> findByCategoryIdAndPriceLessThan(int categoryId, double maxPrice) {
        var products = ProductRepo.findByCategoryIdAndPriceLessThan(categoryId, maxPrice);
        List<ProductDto> result = mapper.map(products, new TypeToken<List<ProductDto>>() {
        }.getType());
        return result;
    }

    @Override
    public List<ProductDto> findByNameContaining(String keyword) {
        var products = ProductRepo.findByNameContaining(keyword);
        List<ProductDto> result = mapper.map(products, new TypeToken<List<ProductDto>>() {
        }.getType());
        return result;
    }

    @Override
    public List<ProductDto> filterBy(ProductFilterDto productFilterDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filterBy'");
    }
}
