package com.example.demo.service;


import com.example.demo.dto.AddressDto;
import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(int id);

    UserDto addUser(UserDto userDto);

    UserDto updateUser(int id, UserDto userDto);

    void deleteUser(int id);
}
