package miu.ea.service.impl;

import miu.ea.payload.UserDto;
import miu.ea.repository.UserRepository;
import miu.ea.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> findAllUsers() {
        return null;
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public UserDto getUserById(int id) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        return null;
    }

} // End of UserServiceImpl class.
