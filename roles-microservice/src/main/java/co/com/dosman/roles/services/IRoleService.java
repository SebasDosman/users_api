package co.com.dosman.roles.services;

import co.com.dosman.roles.dto.CreateRoleDTO;
import co.com.dosman.roles.dto.GetRoleDTO;
import co.com.dosman.roles.dto.UpdateRoleDTO;
import co.com.dosman.roles.exceptions.ConflictException;
import co.com.dosman.roles.exceptions.NotFoundException;
import co.com.dosman.roles.exceptions.RoleException;

import java.util.List;


public interface IRoleService {
    String deleteRole(Long id) throws RoleException, NotFoundException;
    List<GetRoleDTO> getAllRoles();
    GetRoleDTO getRoleById(Long id) throws RoleException, NotFoundException;
    GetRoleDTO saveRole(CreateRoleDTO createRoleDTO) throws RoleException, ConflictException;
    GetRoleDTO updateRole(UpdateRoleDTO updateRoleDTO) throws RoleException, NotFoundException;
}
