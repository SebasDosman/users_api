package co.com.dosman.users.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.dosman.users.dto.CreateUserDTO;
import co.com.dosman.users.dto.GetUserDTO;
import co.com.dosman.users.dto.MessageDTO;
import co.com.dosman.users.dto.UpdateUserDTO;
import co.com.dosman.users.exceptions.ConflictException;
import co.com.dosman.users.exceptions.NotFoundException;
import co.com.dosman.users.exceptions.UserException;
import co.com.dosman.users.services.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
    private final IUserService userService;

    @DeleteMapping(path = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDTO> deleteUser(@PathVariable Long id) throws UserException, NotFoundException {
        return new ResponseEntity<MessageDTO>(MessageDTO.builder().message(userService.deleteUser(id)).build(),
                HttpStatus.OK);
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
    public ResponseEntity<GetUserDTO> saveUser(@Valid @RequestBody CreateUserDTO createUserDTO)
            throws UserException, ConflictException {
        return new ResponseEntity<GetUserDTO>(userService.saveUser(createUserDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDTO> updateUser(@Valid @RequestBody UpdateUserDTO updateUserDTO)
            throws UserException, NotFoundException {
        return new ResponseEntity<GetUserDTO>(userService.updateUser(updateUserDTO), HttpStatus.OK);
    }

    @PutMapping(path = "/updateUserRole/{userId}/{newRoleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDTO> updateUserRole(@PathVariable Long userId, @PathVariable Long newRoleId)
            throws UserException, NotFoundException {
        return new ResponseEntity<GetUserDTO>(userService.updateUserRole(userId, newRoleId), HttpStatus.OK);
    }

}
