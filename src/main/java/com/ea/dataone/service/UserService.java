package com.ea.dataone.service;

import com.ea.dataone.entity.User;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> findAll();

    void update(User user);

    User getUser(Long id);

    void delete(User user);
}
