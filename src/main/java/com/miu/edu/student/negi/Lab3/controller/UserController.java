package com.miu.edu.student.negi.Lab3.controller;

import com.miu.edu.student.negi.Lab3.model.User;
import com.miu.edu.student.negi.Lab3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }
    @GetMapping ("/{id}")
        public User findUserById(@PathVariable int id){
       return userService.getUserById(id);
        }

        @PostMapping()
    public  User addUser(@RequestBody User user){
        return userService.addUser(user);
        }
        @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id ){
        userService.deleteUserById(id);
        }

}
