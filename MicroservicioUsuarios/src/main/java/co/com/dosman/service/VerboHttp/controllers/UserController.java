package co.com.dosman.service.VerboHttp.controllers;

import co.com.dosman.service.VerboHttp.dto.*;
import co.com.dosman.service.VerboHttp.exceptions.UserException;
import co.com.dosman.service.VerboHttp.services.implementations.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @DeleteMapping(path = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDTO> deleteUser(@PathVariable Long id) throws UserException {
            return new ResponseEntity<MessageDTO>(MessageDTO.builder().message(userService.deleteUser(id)).build(), HttpStatus.OK);
    }

    @GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<?>> getAllUsers() {
        return new ResponseEntity<List<?>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/getUserById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDTO> getUserById(@PathVariable Long id) throws UserException {
        return new ResponseEntity<GetUserDTO>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDTO> saveUser(@Valid @RequestBody CreateUserDTO createUserDTO) throws UserException {
            return new ResponseEntity<GetUserDTO>(userService.saveUser(createUserDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDTO> updateUser(@Valid @RequestBody UpdateUserDTO updateUserDTO) throws UserException {
            return new ResponseEntity<GetUserDTO>(userService.updateUser(updateUserDTO), HttpStatus.OK);
    }
}
