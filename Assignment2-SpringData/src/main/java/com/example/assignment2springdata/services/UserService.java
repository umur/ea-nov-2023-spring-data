package com.example.assignment2springdata.services;

import com.example.assignment2springdata.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

    void update(User user, Long id);

    User getUser(Long id);

    void delete(Long id);
}
