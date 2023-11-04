package miu.ea.service.impl;

import miu.ea.entity.Product;
import miu.ea.payload.ProductDto;
import miu.ea.repository.ProductRepository;
import miu.ea.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    }

    @Override
    public ProductDto getProductById(int id) {
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, int id) {
        return null;
    }

} // End of ProductServiceImpl class
