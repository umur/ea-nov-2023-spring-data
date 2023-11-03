package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    final UserService addressService;

    @GetMapping()
    public List<UserDto> findAll() {
        return addressService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable int id) {
        return addressService.getUserById(id);
    }

    @PostMapping()
    public UserDto create(@RequestBody UserDto reviewDto) {
        return addressService.addUser(reviewDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable int id, @RequestBody UserDto reviewDto) {
        return addressService.updateUser(id, reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.deleteUser(id);
    }
}
