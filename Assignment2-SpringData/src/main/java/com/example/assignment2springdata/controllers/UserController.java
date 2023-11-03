package com.example.assignment2springdata.controllers;

import com.example.assignment2springdata.models.Product;
import com.example.assignment2springdata.models.User;
import com.example.assignment2springdata.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void saveUser(@RequestBody User user){
         userService.save(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUsers(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id){
        userService.update(user,id);
    }

}
