package co.com.dosman.users.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.dosman.users.dto.CreateUserDTO;
import co.com.dosman.users.dto.GetUserDTO;
import co.com.dosman.users.dto.UpdateUserDTO;
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

    @Override
    public String deleteUser(Long id) throws UserException {
        if (id == null) throw new UserException(UserValidate.ID_NOT_NULL);
        if (!userRepository.existsById(id)) throw new UserException(UserValidate.USER_NOT_FOUND);

        userRepository.delete(userRepository.getReferenceById(id));

        return String.format(UserValidate.USER_ELIMINATED, id);
    }

    @Override
    public List<GetUserDTO> getAllUsers() {
        return UserMapper.modelToGetUserDto(userRepository.findAll());
    }

    @Override
    public GetUserDTO getUserById(Long id) throws UserException {
        if (id == null) throw new UserException(UserValidate.ID_NOT_NULL);
        if (!userRepository.existsById(id)) throw new UserException(UserValidate.USER_NOT_FOUND);

        return UserMapper.modelToGetUserDto(userRepository.getReferenceById(id));
    }
    
    @Override
    public GetUserDTO saveUser(CreateUserDTO createUserDTO) throws UserException {
        if (createUserDTO == null) throw new UserException(UserValidate.USER_NOT_NULL);
        if (userRepository.existsByEmail(createUserDTO.getEmail())) throw new UserException(UserValidate.EMAIL_ALREADY_EXISTS);

        return UserMapper.modelToGetUserDto(userRepository.save(UserMapper.createUserDtoToModel(createUserDTO)));
    }

    @Override
    public GetUserDTO updateUser(UpdateUserDTO updateUserDTO) throws UserException {
        if (updateUserDTO == null) throw new UserException(UserValidate.USER_NOT_NULL);
        if (!userRepository.existsById(updateUserDTO.getId())) throw new UserException(UserValidate.USER_NOT_FOUND);

        return UserMapper.modelToGetUserDto(userRepository.save(UserMapper.updateUserDtoToModel(updateUserDTO)));
    }
}
