package co.com.dosman.usuarios.services;

import java.util.List;

import co.com.dosman.usuarios.dto.CreateUserDTO;
import co.com.dosman.usuarios.dto.GetUserDTO;
import co.com.dosman.usuarios.dto.UpdateUserDTO;
import co.com.dosman.usuarios.exceptions.UserException;

public interface IUserService {
    String deleteUser(Long id) throws UserException;
    List<GetUserDTO> getAllUsers();
    GetUserDTO getUserById(Long id) throws UserException;
    GetUserDTO saveUser(CreateUserDTO createUserDTO) throws UserException;
    GetUserDTO updateUser(UpdateUserDTO updateUserDTO) throws UserException;
}
