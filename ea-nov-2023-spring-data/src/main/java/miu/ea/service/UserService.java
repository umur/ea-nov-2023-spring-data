package miu.ea.service;

import miu.ea.entity.Product;
import miu.ea.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();
}
