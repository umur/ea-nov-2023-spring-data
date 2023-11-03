package com.example.lab3.Service.Impl;

import com.example.lab3.Model.User;
import com.example.lab3.Repository.UserRepo;
import com.example.lab3.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public User findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
    return userRepo.updateById(id,user);
    }

    @Override
    public void deleteUser(int id) {
    userRepo.deleteById(id);
    }
}
