package com.assginments.lab.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.assginments.lab.dto.UserDto;
import com.assginments.lab.entity.User;
import com.assginments.lab.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final UserRepo UserRepo;
    private final AddressService addressService;
    private final ModelMapper mapper;

    // findAll
    public List<UserDto> findAll() {
        var users = UserRepo.findAll();
        List<UserDto> result = mapper.map(users, new TypeToken<List<UserDto>>() {
        }.getType());
        return result;
    }

    // findById
    public UserDto findById(int id) {
        return mapper.map(UserRepo.findById(id), UserDto.class);
    }

    // Add
    public void add(UserDto newUser) {
        var User = mapper.map(newUser, User.class);
        addressService.add(newUser.getAddress());
        UserRepo.save(User);
    }

    // update
    public void update(int id, UserDto updatedUserDto) {

    }

    // remove
    public void remove(int id) {
        UserRepo.deleteById(id);
    }
}
