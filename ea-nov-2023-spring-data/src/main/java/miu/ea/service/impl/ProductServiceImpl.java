package miu.ea.service.impl;

import miu.ea.entity.Product;
import miu.ea.repository.ProductRepository;
import miu.ea.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
