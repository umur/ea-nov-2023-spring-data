package miu.ea.service;

import miu.ea.entity.Product;
import miu.ea.payload.ProductDto;

import java.util.List;

public interface ProductService {
    public ProductDto createProduct(ProductDto productDto);

    public List<ProductDto> findAllProducts();

    void deleteProductById(int id);

    public ProductDto getProductById(int id);
	
    public ProductDto updateProduct(ProductDto productDto, int id);

    /**
     * Return all products by a given selected category.
     */

    List<ProductDto> getProductByCategory(int categoryId);

}
