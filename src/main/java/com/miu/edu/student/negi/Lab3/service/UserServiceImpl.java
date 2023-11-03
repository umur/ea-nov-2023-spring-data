package com.miu.edu.student.negi.Lab3.service;

import com.miu.edu.student.negi.Lab3.model.User;
import com.miu.edu.student.negi.Lab3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private  final UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("""
               no such element with an id:${id}"""));
    }

    @Override
    public void deleteUserById(int id) {
     userRepository.deleteById(id);
    }

    @Override
    public User UpdateUser(int id, User user) {
        if(userRepository.existsById(id)){
            user.setId(id);
            userRepository.save(user);
        }throw new RuntimeException("""
                nothing to update""");
    }
}
