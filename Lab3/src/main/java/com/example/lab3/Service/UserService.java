package com.example.lab3.Service;

import com.example.lab3.Model.User;

import java.util.Optional;

public interface UserService {
    User findById(int id);
    User saveUser(User user);
    void updateUser(int id,User user);
    void deleteUser(int id);

}
