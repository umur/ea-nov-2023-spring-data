package com.assignemnts.assignment2.controller;

import com.assignemnts.assignment2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")

public class UserController {
    private final UserService userService;

}
