package com.example.lab2.service;

import com.example.lab2.dto.UserDto;
import com.example.lab2.entity.User;
import java.util.List;
public interface UserService {
    void save(User user);
    List<UserDto> findAll();
    User findById(int id);
    void deleteById(int id);
    void update(int id, User user);
}
