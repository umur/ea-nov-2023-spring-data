package com.assignemnts.assignment2.service.impl;

import com.assignemnts.assignment2.dto.get.GetFullProductDto;
import com.assignemnts.assignment2.dto.post.PostFullProductDto;
import com.assignemnts.assignment2.model.Category;
import com.assignemnts.assignment2.model.Product;
import com.assignemnts.assignment2.model.Review;
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
    public List<GetFullProductDto> findAll() {
        return productRepo.findAll().stream()
                .map(product -> {
                    GetFullProductDto res = modelMapper.map(product, GetFullProductDto.class);
                    res.setCategoryName(res.getCategory().getName());
                    return res;
                })
                .collect(Collectors.toList());
    }

    @Override
    public GetFullProductDto findById(Long id) {
        return modelMapper.map(productRepo.findById(id), GetFullProductDto.class);
    }

    @Override
    public List<GetFullProductDto> searchByMinPrice(Double minPrice) {
        return productRepo.findAllByPriceGreaterThan(minPrice).stream()
                .map(p -> modelMapper.map(p, GetFullProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<GetFullProductDto> searchByCatAndMaxPrice(String cat, double maxPrice) {
        return productRepo.findAllByCategory_NameAndPriceLessThan(cat, maxPrice).stream()
                .map(p -> modelMapper.map(p, GetFullProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<GetFullProductDto> searchByNameContains(String keyword) {
        return productRepo.findAllByNameContaining(keyword).stream()
                .map(p -> modelMapper.map(p, GetFullProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetFullProductDto save(PostFullProductDto fullProductDto) {
        Product saved = productRepo.save(modelMapper.map(fullProductDto, Product.class));
        return modelMapper.map(saved, GetFullProductDto.class);
    }

    @Override
    public GetFullProductDto update(PostFullProductDto fullProductDto, Long id) {
        Product currentProduct = productRepo.findById(id).orElseThrow();
        currentProduct.setName(fullProductDto.getName());
        currentProduct.setPrice(fullProductDto.getPrice());
        currentProduct.setRating(fullProductDto.getRating());
        currentProduct.setCategory(modelMapper.map(fullProductDto.getCategory(), Category.class));
        currentProduct.setReviewList(fullProductDto.getReviewList().stream()
                .map(r -> modelMapper.map(r, Review.class))
                .collect(Collectors.toList()));
        productRepo.save(currentProduct);
        return modelMapper.map(currentProduct, GetFullProductDto.class);
    }

    @Override
    public GetFullProductDto delete(Long id) {
        Product deleteProduct = productRepo.findById(id).orElseThrow();
        //GetFullProductDto res = modelMapper.map(x, GetFullProductDto.class);
        productRepo.delete(deleteProduct);
        return null;
    }

}
