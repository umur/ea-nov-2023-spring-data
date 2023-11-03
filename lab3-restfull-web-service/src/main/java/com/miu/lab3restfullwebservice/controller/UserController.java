package com.miu.lab3restfullwebservice.controller;

import com.miu.lab3restfullwebservice.dto.UserDto;
import com.miu.lab3restfullwebservice.exceptions.ResourceNotFoundException;
import com.miu.lab3restfullwebservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/user")
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Integer id) {
        UserDto user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(userService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<UserDto>> pageQuery(UserDto userDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<UserDto> userPage = userService.findByCondition(userDto, pageable);
        return ResponseEntity.ok(userPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody @Validated UserDto userDto, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.update(userDto, id));
    }
}
