package com.ea.dataone.service.impl;

import com.ea.dataone.service.UserService;
import com.ea.dataone.entity.User;
import com.ea.dataone.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

    public void create(User user) {
        userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void update(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }
}
