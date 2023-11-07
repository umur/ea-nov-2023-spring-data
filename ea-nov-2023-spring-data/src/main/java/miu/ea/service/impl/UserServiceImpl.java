package miu.ea.service.impl;

import miu.ea.entity.Address;
import miu.ea.entity.User;
import miu.ea.exception.ResourceNotFoundException;
import miu.ea.payload.UserDto;
import miu.ea.repository.AddressRepository;
import miu.ea.repository.UserRepository;
import miu.ea.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepo;

    public UserServiceImpl(UserRepository userRepo, ModelMapper modelMapper,
                           AddressRepository addressRepo) {
        this.userRepo = userRepo;

        this.modelMapper = modelMapper;
        this.addressRepo = addressRepo;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // To associate User to its address during creation
        Address address = addressRepo.findById(userDto.getAddressId()).orElseThrow(() ->
                new ResourceNotFoundException("Address", "id", userDto.getAddressId()));
        // Convert Dto to Entity
        User user = modelMapper.map(userDto, User.class);
        user.setAddress(address);
        User newUser = userRepo.save(user);
        return modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(int id) {
        User user = userRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
        userRepo.delete(user);

    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
        return modelMapper.map(user, UserDto.class);

    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        // Get User by Id from the database.
        User user = userRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
        // Get Address by Id from the database.
        Address address = addressRepo.findById(userDto.getAddressId()).orElseThrow(() ->
                new ResourceNotFoundException("Address", "id", userDto.getAddressId()));
        user.setId(id);
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        // Set Address before saving user to the database.
        user.setAddress(address);

        User updatedUser = userRepo.save(user);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getUsersByAddress(int addressId) {
        // Get address by Id from the database.
        Address address = addressRepo.findById(addressId).orElseThrow(() ->
                new ResourceNotFoundException("Address", "id", addressId));

        List<User> users = userRepo.findByAddressId(addressId);

        return users.stream().map((p) -> modelMapper.map(p, UserDto.class))
                .collect(Collectors.toList());
    }

} // End of UserServiceImpl class.
