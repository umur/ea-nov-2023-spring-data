package edu.ea.springdata1.service;

import edu.ea.springdata1.dto.FullUserDto;

import java.util.List;

public interface UserService
{
    List<FullUserDto> findAll();
    FullUserDto findById(Integer id) throws Exception;
    FullUserDto add(FullUserDto userDto);
    FullUserDto update(Integer  id,FullUserDto userDto) throws Exception;
    boolean delete(Integer userId) throws Exception;




}
