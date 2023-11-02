package com.example.lab2.service.impl;
import com.example.lab2.dto.UserDto;
import com.example.lab2.entity.User;
import com.example.lab2.repository.UserRepo;
import com.example.lab2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepo.findAll();
        var res = new ArrayList<UserDto>();
        users.forEach(user -> {
            UserDto userdto = modelMapper.map(user, UserDto.class);
            res.add(userdto);
        });
        return res;
    }

    @Override
    public User findById(int id) {
        var user = userRepo.findById(id);
        return modelMapper.map(user, User.class);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(int id, User user) {
        var user1 = userRepo.findById(id);
        if (user1 != null) {
            userRepo.save(user);
        }
    }
}
