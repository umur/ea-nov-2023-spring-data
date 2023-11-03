package com.miu.edu.student.negi.Lab3.service;

import com.miu.edu.student.negi.Lab3.model.User;

import java.util.List;

public interface UserService {
    List<User>getAllUser();
    User addUser(User user);
    User getUserById(int id);
    void deleteUserById(int id);
    User UpdateUser(int id,User user);
}
