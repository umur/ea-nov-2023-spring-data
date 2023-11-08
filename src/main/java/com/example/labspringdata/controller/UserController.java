package com.example.labspringdata.controller;

import com.example.labspringdata.Service.UserService;
import com.example.labspringdata.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll()
    {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable int id)
    {
        return  userService.getById(id);
    }
    @PostMapping
    public User save(@RequestBody User user)
    {
        return userService.Save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id , @RequestBody User user)
    {
        return  userService.update(id,user);
    }
}
