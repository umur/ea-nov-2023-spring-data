package miu.ea.repository;

import miu.ea.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {
    public List<Product> findByNameOrPrice(String name, BigDecimal price);
}
