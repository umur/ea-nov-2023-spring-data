package com.example.labspringdata.Service;

import com.example.labspringdata.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getById(int id);
    public User Save(User user);

    public void delete(int id);
    public User update(int id, User user);
}
