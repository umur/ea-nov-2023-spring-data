package miu.ea.controller;

import miu.ea.payload.UserDto;
import miu.ea.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

     /*
    Implement CRUD operations for the domains.*/

    // Get all categories REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    // create category rest api
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    // Get category by {Id} REST API
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Update category by {id} REST API
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                                      @PathVariable(name="id") int id) {

        UserDto userUpdated = userService.updateUser(userDto, id);

        return new ResponseEntity<>(userUpdated, HttpStatus.OK);

    }

    // delete category by {id} REST API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") int id){

        userService.deleteUserById(id);

        return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
    }

    // Get users by address REST API
//    @GetMapping("/address/{id}")
//    public ResponseEntity<List<UserDto>> getUserByAddress(@PathVariable(name = "id") int addressId){
//        List<UserDto> userDtos = userService.getUsersByAddress(addressId);
//        return ResponseEntity.ok(userDtos);
//    }

}
