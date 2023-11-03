package com.miu.lab3restfullwebservice.service;

import com.miu.lab3restfullwebservice.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto save(UserDto userDto);

    void deleteById(Integer id);

    UserDto findById(Integer id);

    Page<UserDto> findByCondition(UserDto userDto, Pageable pageable);

    UserDto update(UserDto userDto, Integer id);
}
