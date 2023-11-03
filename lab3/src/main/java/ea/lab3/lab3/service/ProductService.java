package ea.lab3.lab3.service;

import ea.lab3.lab3.dto.ProductDto;
import ea.lab3.lab3.entity.Category;
import ea.lab3.lab3.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();
    List<ProductDto> findProductCostGreaterThan(double price);

    public List<ProductDto> getProductsByCategoryAndPriceLessThan(Category category, double maxPrice);

    public List<ProductDto> getProductsByNameContaining(String keyword);
}
