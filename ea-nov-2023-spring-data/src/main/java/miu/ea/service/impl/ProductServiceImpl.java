package miu.ea.service.impl;

import miu.ea.entity.Category;
import miu.ea.entity.Product;
import miu.ea.exception.ResourceNotFoundException;
import miu.ea.payload.ProductDto;
import miu.ea.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepo;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepo, CategoryRepository categoryRepo,
                              ModelMapper modelMapper) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        // To associate Product to its Category during creation
        Category category = categoryRepo.findById(productDto.getCategoryId()).orElseThrow(() ->
                new ResourceNotFoundException("Category", "id", productDto.getCategoryId()));
        // Convert Dto to Entity
        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(category);
        Product newProduct = productRepo.save(product);
        // Convert Entity to Dto
        return modelMapper.map(newProduct, ProductDto.class);
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
        // Get product by Id from the database.
        Product product = productRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "id", id));
        // Get category by Id from the database.
        Category category = categoryRepo.findById(productDto.getCategoryId()).orElseThrow(() ->
                new ResourceNotFoundException("Category", "id", productDto.getCategoryId()));
        product.setId(id);
        product.setName(productDto.getName());
        product.setPrice(BigDecimal.valueOf(productDto.getPrice()));
        product.setRating(productDto.getRating());
        // Set category before saving product to the database.
        product.setCategory(category);

        Product updatedProduct = productRepo.save(product);

        return modelMapper.map(updatedProduct, ProductDto.class);
    }

    /**
     * Return all products by a given selected category.
     */
    @Override
    public List<ProductDto> getProductByCategory(int categoryId) {
        // Get category by Id from the database.
        Category category = categoryRepo.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("Category", "id", categoryId));

        List<Product> products = productRepo.findByCategoryId(categoryId);

        return products.stream().map((p) -> modelMapper.map(p, ProductDto.class))
                .collect(Collectors.toList());
    }


} // End of ProductServiceImpl class
