package com.miu.lab3restfullwebservice.repository;

import com.miu.lab3restfullwebservice.entity.Category;
import com.miu.lab3restfullwebservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//    @Query("select p from Product p where p.price > ?1")
    List<Product> findAllByPriceGreaterThan(@NonNull Double minPrice);
    List<Product> findAllByCategoryAndPriceGreaterThan(@NonNull Category category, @NonNull Double minPrice);
    List<Product> findAllByNameContains(String keyword);

}