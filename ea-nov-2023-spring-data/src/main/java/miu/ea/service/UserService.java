package miu.ea.service;

import miu.ea.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    public List<UserDto> findAllUsers();

    void deleteUserById(int id);

    public UserDto getUserById(int id);
	
    public UserDto updateUser(UserDto userDto, int id);

}
