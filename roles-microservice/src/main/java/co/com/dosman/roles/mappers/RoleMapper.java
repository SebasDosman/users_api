package co.com.dosman.roles.mappers;

import co.com.dosman.roles.dto.CreateRoleDTO;
import co.com.dosman.roles.dto.GetRoleDTO;
import co.com.dosman.roles.dto.UpdateRoleDTO;
import co.com.dosman.roles.model.Role;

import java.util.List;
import java.util.stream.Collectors;


public class RoleMapper {
    public static GetRoleDTO modelToGetRoleDto(Role role) {
        return GetRoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

    public static List<GetRoleDTO> modelToGetRoleDto(List<Role> roles) {
        return roles.stream().map(RoleMapper::modelToGetRoleDto).collect(Collectors.toList());
    }

    public static Role updateRoleDtoToModel(UpdateRoleDTO updateRoleDTO) {
        return Role.builder()
                .id(updateRoleDTO.getId())
                .name(updateRoleDTO.getName())
                .description(updateRoleDTO.getDescription())
                .build();
    }

    public static Role createRoleDtoToModel(CreateRoleDTO createRoleDTO) {
        return Role.builder()
                .name(createRoleDTO.getName())
                .description(createRoleDTO.getDescription())
                .build();
    }
}
