package com.miu.lab3restfullwebservice.service.impl;

import com.miu.lab3restfullwebservice.common.Converter;
import com.miu.lab3restfullwebservice.dto.UserDto;
import com.miu.lab3restfullwebservice.entity.User;
import com.miu.lab3restfullwebservice.exceptions.ResourceNotFoundException;
import com.miu.lab3restfullwebservice.repository.UserRepository;
import com.miu.lab3restfullwebservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final Converter converter;

    @Override
    public UserDto save(UserDto userDto) {
        User entity = converter.convert(userDto, User.class);
        return converter.convert(repository.save(entity), UserDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto findById(Integer id) {
        return converter.convert(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new), UserDto.class);
    }

    @Override
    public Page<UserDto> findByCondition(UserDto userDto, Pageable pageable) {
        Page<User> entityPage = repository.findAll(pageable);
        List<User> entities = entityPage.getContent();
        return new PageImpl<>(converter.convertList(entities, UserDto.class), pageable, entityPage.getTotalElements());
    }

    @Override
    public UserDto update(UserDto userDto, Integer id) {
        Optional<User> data = repository.findById(id);
        User updatedEntity = data.map(entity -> converter.convert(userDto, User.class)).orElseThrow(ResourceNotFoundException::new);
        return save(converter.convert(updatedEntity, UserDto.class));
    }
}
