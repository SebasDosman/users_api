package co.com.dosman.users.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.dosman.common.entities.Role;
import co.com.dosman.common.entities.User;
import co.com.dosman.roles.repositories.RoleRepository;
import co.com.dosman.roles.utilities.RoleValidate;
import co.com.dosman.users.dto.CreateUserDTO;
import co.com.dosman.users.dto.GetUserDTO;
import co.com.dosman.users.dto.UpdateUserDTO;
import co.com.dosman.users.exceptions.ConflictException;
import co.com.dosman.users.exceptions.NotFoundException;
import co.com.dosman.users.exceptions.UserException;
import co.com.dosman.users.mappers.UserMapper;
import co.com.dosman.users.repositories.UserRepository;
import co.com.dosman.users.services.IUserService;
import co.com.dosman.users.utilities.UserValidate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Override
	public String deleteUser(Long id) throws UserException, NotFoundException {
		if (id == null)
			throw new UserException(UserValidate.ID_NOT_NULL);
		if (!userRepository.existsById(id))
			throw new NotFoundException(UserValidate.USER_NOT_FOUND);

		userRepository.delete(userRepository.getReferenceById(id));

		return String.format(UserValidate.USER_ELIMINATED, id);
	}

	@Override
	public List<GetUserDTO> getAllUsers() {
		return UserMapper.modelToGetUserDto(userRepository.findAll());
	}

	@Override
	public GetUserDTO getUserById(Long id) throws UserException, NotFoundException {
		if (id == null)
			throw new UserException(UserValidate.ID_NOT_NULL);
		if (!userRepository.existsById(id))
			throw new NotFoundException(UserValidate.USER_NOT_FOUND);

		return UserMapper.modelToGetUserDto(userRepository.getReferenceById(id));
	}

	@Override
	public GetUserDTO saveUser(CreateUserDTO createUserDTO) throws UserException, ConflictException {
		User newUser = UserMapper.createUserDtoToModel(createUserDTO);

		Role userRole = roleRepository.findByName("USER");
		if (userRole == null) {
			throw new UserException(RoleValidate.ROLE_NOT_FOUND);
		}

		newUser.setRole(userRole);

		return UserMapper.modelToGetUserDto(userRepository.save(newUser));
	}

	@Override
	public GetUserDTO updateUser(UpdateUserDTO updateUserDTO) throws UserException, NotFoundException {
		if (updateUserDTO == null)
			throw new UserException(UserValidate.USER_NOT_NULL);
		if (!userRepository.existsById(updateUserDTO.getId()))
			throw new NotFoundException(UserValidate.USER_NOT_FOUND);

		User userToUpdate = UserMapper.updateUserDtoToModel(updateUserDTO);

		if (updateUserDTO.getRole_id() != null) { 
		    Role newRole = roleRepository.findById(updateUserDTO.getRole_id()) 
		        .orElseThrow(() -> new NotFoundException(RoleValidate.ROLE_NOT_FOUND));
		    userToUpdate.setRole(newRole);
		}

		return UserMapper.modelToGetUserDto(userRepository.save(userToUpdate));
	}

	public GetUserDTO updateUserRole(Long userId, Long newRoleId) throws UserException, NotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new NotFoundException(UserValidate.USER_NOT_FOUND));

		Role newRole = roleRepository.findById(newRoleId)
				.orElseThrow(() -> new NotFoundException(RoleValidate.ROLE_NOT_FOUND));

		user.setRole(newRole);

		return UserMapper.modelToGetUserDto(userRepository.save(user));
	}
}