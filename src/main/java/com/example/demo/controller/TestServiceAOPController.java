package com.example.demo.controller;

import com.example.demo.aspect.annotaions.ExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceAOPController {
    @GetMapping("/test-log")
    @ExecutionTime
    public String testLog() {
        return "this is a test log response";
    }
}
