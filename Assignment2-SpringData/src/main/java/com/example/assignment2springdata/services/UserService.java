package com.example.assignment2springdata.services;

import com.example.assignment2springdata.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

    void update(User user);

    User getUser(Long id);

    void delete(Long id);
}
