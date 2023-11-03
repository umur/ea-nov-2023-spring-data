package edu.ea.springdata1.service.impl;

import edu.ea.springdata1.dto.FullAddressDto;

import edu.ea.springdata1.dto.FullUserDto;
import edu.ea.springdata1.model.Address;
import edu.ea.springdata1.model.User;
import edu.ea.springdata1.repository.AddressRepo;
import edu.ea.springdata1.repository.UserRepo;
import edu.ea.springdata1.service.AddressService;
import edu.ea.springdata1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService
{
    private final AddressRepo addressRepo;
    private final UserService userService;
    private final ModelMapper modelMapper;



    @Override
    public FullAddressDto findUserAddress(Integer userId) throws Exception {
        FullUserDto fullUserDto= userService.findById(userId);
        return fullUserDto.getAddress();

    }

    @Override
    @Transactional
    public FullAddressDto add(Integer userId, FullAddressDto addressDto) throws Exception {
        FullUserDto fullUserDto= userService.findById(userId);

        if(fullUserDto.getAddress() !=null)
            throw  new Exception("User already have address");
        Address saveAddress = addressRepo.save(modelMapper.map(addressDto, Address.class));
        fullUserDto.setAddress(modelMapper.map(saveAddress,FullAddressDto.class));
        FullUserDto updateUser = userService.update(fullUserDto.getId(), fullUserDto);



        return updateUser.getAddress();
    }

    @Override
    @Transactional
    public FullAddressDto update(Integer addressId, FullAddressDto addressDto) throws Exception {


        Optional<Address> optAddress = addressRepo.findById(addressId);
        if(!optAddress.isPresent())
            throw  new Exception("Address not found");
       Address address= modelMapper.map(addressDto,Address.class);
        address.setId(addressId);
        Address savedAddress = addressRepo.save(address);
        return  modelMapper.map(savedAddress,FullAddressDto.class);

    }
}
