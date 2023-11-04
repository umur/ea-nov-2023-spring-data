package com.assignemnts.assignment2.service;

import com.assignemnts.assignment2.dto.get.GetFullUserDto;
import com.assignemnts.assignment2.dto.post.PostFullUserDto;

import java.util.List;

public interface UserService {

    List<GetFullUserDto> findAll();

    GetFullUserDto findById(Long id);

    GetFullUserDto save(PostFullUserDto fullUserDto);
    GetFullUserDto update(PostFullUserDto fullUserDto, Long id);
    GetFullUserDto delete(Long id);


}
