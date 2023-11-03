package edu.ea.springdata1.service.impl;



import edu.ea.springdata1.dto.FullProductDto;

import edu.ea.springdata1.dto.FullReviewDto;
import edu.ea.springdata1.model.Product;
import edu.ea.springdata1.model.Review;
import edu.ea.springdata1.repository.ProductRepo;
import edu.ea.springdata1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private  final ModelMapper modelMapper;



    @Override
    public List<FullProductDto> findAll() {
        return productRepo.findAll().stream().map(c ->  modelMapper.map(c,FullProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public FullProductDto findById(Integer id) throws Exception {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(!optionalProduct.isPresent())
            throw  new Exception("Product not found");
        Product product = optionalProduct.get();

        return modelMapper.map(product,FullProductDto.class);
    }

    @Override
    @Transactional
    public FullProductDto add(FullProductDto productDto)   {
      return modelMapper.map( productRepo.save(modelMapper.map(productDto,Product.class)),FullProductDto.class);
    }




    @Override
    @Transactional
    public FullProductDto update(Integer id, FullProductDto productDto) throws Exception {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(!optionalProduct.isPresent())
            throw  new Exception("Product not found");
        productDto.setId(id);
       return modelMapper.map( productRepo.save(modelMapper.map(productDto,Product.class)),FullProductDto.class);

    }

    @Override
    @Transactional
    public boolean delete(Integer id) throws Exception {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(!optionalProduct.isPresent())
            throw  new Exception("Product not found");
        Product product = optionalProduct.get();
        product.setDeleted(true);
        productRepo.save(product);
        return true;
    }
}
