package miu.ea.service.impl;

import miu.ea.entity.Product;
import miu.ea.exception.ResourceNotFoundException;
import miu.ea.payload.ProductDto;
import miu.ea.repository.ProductRepository;
import miu.ea.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepo;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepo, ModelMapper modelMapper) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product savedProduct = productRepo.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map((p) -> modelMapper.map(p, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProductById(int id) {
        Product product = productRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "id", id));

        productRepo.delete(product);
    }

    @Override
    public ProductDto getProductById(int id) {
        Product product = productRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "id", id));

        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, int id) {
        Product product = productRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "id", id));
        product.setId(id);
        product.setName(productDto.getName());
        product.setPrice(BigDecimal.valueOf(productDto.getPrice()));
        product.setRating(productDto.getRating());

        Product updatedProduct = productRepo.save(product);

        return modelMapper.map(updatedProduct, ProductDto.class);
    }

} // End of ProductServiceImpl class
