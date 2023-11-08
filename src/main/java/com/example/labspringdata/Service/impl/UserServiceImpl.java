package com.example.labspringdata.Service.impl;

import com.example.labspringdata.Service.UserService;
import com.example.labspringdata.entity.User;
import com.example.labspringdata.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getById(int id) {
        User existingUser = userRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));

        return existingUser;
    }

    @Override
    public User Save(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public void delete(int id) {
        userRepo.delete(getById(id));
    }

    @Override
    public User update(int id, User user) {
        User existingUser = getById(id);
        BeanUtils.copyProperties(user,existingUser);
        userRepo.save(existingUser);
        return existingUser;
    }
}
