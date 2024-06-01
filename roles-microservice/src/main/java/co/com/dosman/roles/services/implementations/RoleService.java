package co.com.dosman.roles.services.implementations;

import co.com.dosman.roles.dto.CreateRoleDTO;
import co.com.dosman.roles.dto.GetRoleDTO;
import co.com.dosman.roles.dto.UpdateRoleDTO;
import co.com.dosman.roles.exceptions.RoleException;
import co.com.dosman.roles.mappers.RoleMapper;
import co.com.dosman.roles.repositories.RoleRepository;
import co.com.dosman.roles.services.IRoleService;
import co.com.dosman.roles.utilities.RoleValidate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    @Override
    public String deleteRole(Long id) throws RoleException {
        if (id == null) throw new RoleException(RoleValidate.ID_NOT_NULL);
        if (!roleRepository.existsById(id)) throw new RoleException(RoleValidate.ROLE_NOT_FOUND);

        roleRepository.delete(roleRepository.getReferenceById(id));

        return String.format(RoleValidate.ROLE_ELIMINATED, id);
    }

    @Override
    public List<GetRoleDTO> getAllRoles() {
        return RoleMapper.modelToGetRoleDto(roleRepository.findAll());
    }

    @Override
    public GetRoleDTO getRoleById(Long id) throws RoleException {
        if (id == null) throw new RoleException(RoleValidate.ID_NOT_NULL);
        if (!roleRepository.existsById(id)) throw new RoleException(RoleValidate.ROLE_NOT_FOUND);

        return RoleMapper.modelToGetRoleDto(roleRepository.getReferenceById(id));
    }

    @Override
    public GetRoleDTO saveRole(CreateRoleDTO createRoleDTO) throws RoleException {
        if (createRoleDTO == null) throw new RoleException(RoleValidate.ROLE_NOT_NULL);
        if (roleRepository.existsByName(createRoleDTO.getName())) throw new RoleException(RoleValidate.NAME_ALREADY_EXISTS);

        return RoleMapper.modelToGetRoleDto(roleRepository.save(RoleMapper.createRoleDtoToModel(createRoleDTO)));
    }

    @Override
    public GetRoleDTO updateRole(UpdateRoleDTO updateRoleDTO) throws RoleException {
        if (updateRoleDTO == null) throw new RoleException(RoleValidate.ROLE_NOT_NULL);
        if (!roleRepository.existsById(updateRoleDTO.getId())) throw new RoleException(RoleValidate.ROLE_NOT_FOUND);

        return RoleMapper.modelToGetRoleDto(roleRepository.save(RoleMapper.updateRoleDtoToModel(updateRoleDTO)));
    }
}
