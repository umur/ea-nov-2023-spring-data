package miu.ea.repository;

import miu.ea.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {

    /**
     * Return all products by a given name or price passed as the method parameter.
     */

    public List<Product> findByNameOrPrice(String name, BigDecimal price);

    /**
     *  Return the product list whose price is greater than the given price (minPrice)
     *  as the method parameter.
     */

    public List<Product> findByPriceGreaterThan(BigDecimal minPrice);

    /**
     *  Return the product list whose price is less than the given price (maxPrice)
     *  as the method parameter.
     */
    public List<Product> findByPriceLessThan(BigDecimal maxPrice);

    /**
     * Find all products that contain keyword in the name.
     */


    /**
     *   Find reviews of the product whose id is id.
     */

}
