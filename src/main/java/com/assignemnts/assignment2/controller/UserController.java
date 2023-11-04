package com.assignemnts.assignment2.controller;

import com.assignemnts.assignment2.dto.get.GetFullUserDto;
import com.assignemnts.assignment2.dto.post.PostFullUserDto;
import com.assignemnts.assignment2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    @GetMapping
    public List<GetFullUserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public GetFullUserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public GetFullUserDto save(@RequestBody PostFullUserDto fullUserDto) {
        return userService.save(fullUserDto);
    }

    @PutMapping("/{id}")
    public GetFullUserDto update(@RequestBody PostFullUserDto fullUserDto, @PathVariable Long id) {
        try {
            return userService.update(fullUserDto, id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @DeleteMapping("/{id}")
    public GetFullUserDto delete(@PathVariable Long id) {
        try {
            return userService.delete(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

}
