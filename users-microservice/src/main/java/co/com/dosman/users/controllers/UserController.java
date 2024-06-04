package co.com.dosman.users.controllers;

import co.com.dosman.users.exceptions.ConflictException;
import co.com.dosman.users.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.com.dosman.users.dto.*;
import co.com.dosman.users.exceptions.UserException;
import co.com.dosman.users.services.IUserService;


@AllArgsConstructor
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
    private final IUserService userService;

    @DeleteMapping(path = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDTO> deleteUser(@PathVariable Long id) throws UserException, NotFoundException {
        return new ResponseEntity<MessageDTO>(MessageDTO.builder().message(userService.deleteUser(id)).build(), HttpStatus.OK);
    }

    @GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetUserDTO>> getAllUsers() {
        return new ResponseEntity<List<GetUserDTO>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/getUserById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDTO> getUserById(@PathVariable Long id) throws UserException, NotFoundException {
        return new ResponseEntity<GetUserDTO>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDTO> saveUser(@Valid @RequestBody CreateUserDTO createUserDTO) throws UserException, ConflictException {
        return new ResponseEntity<GetUserDTO>(userService.saveUser(createUserDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDTO> updateUser(@Valid @RequestBody UpdateUserDTO updateUserDTO) throws UserException, NotFoundException {
        return new ResponseEntity<GetUserDTO>(userService.updateUser(updateUserDTO), HttpStatus.OK);
    }
}
