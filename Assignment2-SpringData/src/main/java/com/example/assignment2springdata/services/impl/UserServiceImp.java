package com.example.assignment2springdata.services.impl;

import com.example.assignment2springdata.models.User;
import com.example.assignment2springdata.repository.UserRepo;
import com.example.assignment2springdata.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {


    private final UserRepo userRepo;

    public void save(User user) {
        userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void update(User user, Long id) {
        User user1 = userRepo.findById(id).get();
        if(user1!=null){
            user1.setId(user.getId());
            user1.setEmail(user.getEmail());
            user1.setFirstName(user.getFirstName());
            user1.setLastname(user.getLastname());
            user1.setLastname(user.getLastname());

            userRepo.save(user);
        }

    }

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}