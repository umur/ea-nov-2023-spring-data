package com.assignemnts.assignment2.service.impl;

import com.assignemnts.assignment2.dto.get.GetFullUserDto;
import com.assignemnts.assignment2.dto.post.PostFullUserDto;
import com.assignemnts.assignment2.model.Address;
import com.assignemnts.assignment2.model.Review;
import com.assignemnts.assignment2.model.User;
import com.assignemnts.assignment2.repository.UserRepo;
import com.assignemnts.assignment2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<GetFullUserDto> findAll() {
        return userRepo.findAll().stream()
                .map(user -> modelMapper.map(user, GetFullUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetFullUserDto findById(Long id) {
        return modelMapper.map(userRepo.findById(id), GetFullUserDto.class);
    }

    @Override
    public GetFullUserDto save(PostFullUserDto fullUserDto) {
        User saved = userRepo.save(modelMapper.map(fullUserDto, User.class));
        return modelMapper.map(saved, GetFullUserDto.class);
    }

    @Override
    public GetFullUserDto update(PostFullUserDto fullUserDto, Long id) {
        User currentUser = userRepo.findById(id).orElseThrow();
        currentUser.setEmail(fullUserDto.getEmail());
        currentUser.setPassword(fullUserDto.getPassword());
        currentUser.setFirstName(fullUserDto.getFirstName());
        currentUser.setLastName(fullUserDto.getLastName());
        currentUser.setAddress(modelMapper.map(fullUserDto.getAddress(), Address.class));
        currentUser.setReviewList(
                fullUserDto.getReviewList().stream()
                        .map(r -> modelMapper.map(r, Review.class))
                        .collect(Collectors.toList()));
        userRepo.save(currentUser);
        return modelMapper.map(currentUser, GetFullUserDto.class);
    }

    @Override
    public GetFullUserDto delete(Long id) {
        User deleteUser = userRepo.findById(id).orElseThrow();
        //GetFullUserDto res = modelMapper.map(deleteUser, GetFullUserDto.class);
        userRepo.deleteById(deleteUser.getId());
        return null;
    }
}
