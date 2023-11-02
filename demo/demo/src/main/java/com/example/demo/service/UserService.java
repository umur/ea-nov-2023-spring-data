package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(long id);

    public User createUser(User user);

    public User updateUser(long id, User updatedUser);

    public void deleteUser(long id);
}
