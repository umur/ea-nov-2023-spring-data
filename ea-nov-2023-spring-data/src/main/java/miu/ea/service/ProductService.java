package miu.ea.service;

import miu.ea.payload.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    public List<ProductDto> findAllProducts();

    void deleteProductById(int id);

    public ProductDto getProductById(int id);
    public ProductDto updateProduct(ProductDto productDto, int id);

}
