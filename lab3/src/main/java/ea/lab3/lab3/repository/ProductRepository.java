package ea.lab3.lab3.repository;

import ea.lab3.lab3.entity.Category;
import ea.lab3.lab3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {
    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByCategoryAndPriceLessThan(Category category, double price);
    List<Product> findByNameContaining(String keyword);
}
