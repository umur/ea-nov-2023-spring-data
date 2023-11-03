package com.miu.edu.student.bacha.lab3.repositories;

import com.miu.edu.student.bacha.lab3.models.Category;
import com.miu.edu.student.bacha.lab3.models.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category,Integer> {
    //public List<Product> findAllProductsInCategoryLessThanPrice(double price, Category category);
    public List<Product> findAllProductsByCategoryAndPriceLessThan(double price, Category category);

}
