package co.com.dosman.service.VerboHttp.services;

import java.util.List;

import co.com.dosman.service.VerboHttp.dto.CreateUserDTO;
import co.com.dosman.service.VerboHttp.dto.GetUserDTO;
import co.com.dosman.service.VerboHttp.dto.UpdateUserDTO;
import co.com.dosman.service.VerboHttp.exceptions.UserException;


public interface IUserService {
    String deleteUser(Long id) throws UserException;
    List<GetUserDTO> getAllUsers();
    GetUserDTO getUserById(Long id) throws UserException;
    GetUserDTO saveUser(CreateUserDTO createUserDTO) throws UserException;
    GetUserDTO updateUser(UpdateUserDTO updateUserDTO) throws UserException;
}
