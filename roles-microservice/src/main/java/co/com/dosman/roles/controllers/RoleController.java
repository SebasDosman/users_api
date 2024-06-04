package co.com.dosman.roles.controllers;

import co.com.dosman.roles.dto.CreateRoleDTO;
import co.com.dosman.roles.dto.GetRoleDTO;
import co.com.dosman.roles.dto.MessageDTO;
import co.com.dosman.roles.dto.UpdateRoleDTO;
import co.com.dosman.roles.exceptions.ConflictException;
import co.com.dosman.roles.exceptions.NotFoundException;
import co.com.dosman.roles.exceptions.RoleException;
import co.com.dosman.roles.services.IRoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RequestMapping("/role")
@RestController
@Slf4j
public class RoleController {
    private final IRoleService roleService;

    @DeleteMapping(path = "/deleteRole/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDTO> deleteRole(@PathVariable Long id) throws RoleException, NotFoundException {
        return new ResponseEntity<MessageDTO>(MessageDTO.builder().message(roleService.deleteRole(id)).build(), HttpStatus.OK);
    }

    @GetMapping(path = "/getAllRoles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetRoleDTO>> getAllRoles() {
        return new ResponseEntity<List<GetRoleDTO>>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping(path = "/getRoleById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetRoleDTO> getRoleById(@PathVariable Long id) throws RoleException, NotFoundException {
        return new ResponseEntity<GetRoleDTO>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/saveRole", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetRoleDTO> saveRole(@Valid @RequestBody CreateRoleDTO createRoleDTO) throws RoleException, ConflictException {
        return new ResponseEntity<GetRoleDTO>(roleService.saveRole(createRoleDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateRole", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetRoleDTO> updateRole(@Valid @RequestBody UpdateRoleDTO updateRoleDTO) throws RoleException, NotFoundException {
        return new ResponseEntity<GetRoleDTO>(roleService.updateRole(updateRoleDTO), HttpStatus.OK);
    }
}
