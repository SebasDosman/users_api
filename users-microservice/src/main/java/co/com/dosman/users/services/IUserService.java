package co.com.dosman.users.services;

import java.util.List;

import co.com.dosman.roles.exceptions.RoleException;
import co.com.dosman.users.dto.CreateUserDTO;
import co.com.dosman.users.dto.GetUserDTO;
import co.com.dosman.users.dto.UpdateUserDTO;
import co.com.dosman.users.exceptions.ConflictException;
import co.com.dosman.users.exceptions.NotFoundException;
import co.com.dosman.users.exceptions.UserException;


public interface IUserService {
    String deleteUser(Long id) throws UserException, NotFoundException;
    List<GetUserDTO> getAllUsers();
    GetUserDTO getUserById(Long id) throws UserException, NotFoundException;
    GetUserDTO saveUser(CreateUserDTO createUserDTO) throws UserException, ConflictException;
    GetUserDTO updateUser(UpdateUserDTO updateUserDTO) throws UserException, NotFoundException;
    GetUserDTO assignRoleToUser(Long userId, Long roleId) throws UserException, NotFoundException, RoleException;
}
