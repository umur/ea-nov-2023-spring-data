package miu.ea.repository;

import miu.ea.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {
    // Find all products by a given name or price.
    public List<Product> findByNameOrPrice(String name, BigDecimal price);

    // Find all products that cost more than minPrice
    public List<Product> findByPriceGreaterThan(BigDecimal minPrice);

    // Find all products in cat category and cost less than maxPrice


    // Find all products that contain keyword in the name.


    // Find reviews of the product whose id is id.
}
