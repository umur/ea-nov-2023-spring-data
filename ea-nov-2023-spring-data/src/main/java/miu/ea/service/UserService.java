package miu.ea.service;

import miu.ea.entity.Product;
import miu.ea.entity.User;
import miu.ea.payload.ProductDto;
import miu.ea.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    public List<UserDto> findAllUsers();

    void deleteUserById(int id);

    public UserDto getUserById(int id);
	
    public UserDto updateUser(UserDto userDto, int id);

    /**
     * Return all users by a given selected address.
     */
    List<UserDto> getUsersByAddress(int addressId);

}
