package miu.ea.service.impl;

import miu.ea.entity.Product;
import miu.ea.entity.User;
import miu.ea.repository.UserRepository;
import miu.ea.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void save(User user) {

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
