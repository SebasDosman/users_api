package co.com.dosman.service.VerboHttp.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.dosman.service.VerboHttp.dto.CreateUserDTO;
import co.com.dosman.service.VerboHttp.dto.GetUserDTO;
import co.com.dosman.service.VerboHttp.dto.UpdateUserDTO;
import co.com.dosman.service.VerboHttp.exceptions.UserException;
import co.com.dosman.service.VerboHttp.mappers.UserMapper;
import co.com.dosman.service.VerboHttp.repositories.UserRepository;
import co.com.dosman.service.VerboHttp.services.IUserService;
import co.com.dosman.service.VerboHttp.utilities.UserValidate;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
	
    private final UserRepository userRepository;

    @Override
    public String deleteUser(Long id) throws UserException {
        if (!userRepository.existsById(id)) throw new UserException(UserValidate.USER_NOT_FOUND);

        userRepository.delete(userRepository.findById(id).get());

        return String.format(UserValidate.USER_ELIMINATED, id);
    }

    @Override
    public List<GetUserDTO> getAllUsers() {
        return UserMapper.domainToGetUserDto(userRepository.findAll());
    }

    @Override
    public GetUserDTO getUserById(Long id) throws UserException {
        if (!userRepository.existsById(id)) throw new UserException(UserValidate.USER_NOT_FOUND);

        return UserMapper.domainToGetUserDto(userRepository.findById(id).get());
    }
    
    @Override
    public GetUserDTO saveUser(CreateUserDTO createUserDTO) throws UserException {
        if (userRepository.existsByEmail(createUserDTO.getEmail())) throw new UserException(UserValidate.EMAIL_ALREADY_EXISTS);

        return UserMapper.domainToGetUserDto(userRepository.save(UserMapper.createUserDtoToDomain(createUserDTO)));
    }

    @Override
    public GetUserDTO updateUser(UpdateUserDTO updateUserDTO) throws UserException {
        if (!userRepository.existsById(updateUserDTO.getId())) throw new UserException(UserValidate.USER_NOT_FOUND);

        return UserMapper.domainToGetUserDto(userRepository.save(UserMapper.updateUserDtoToDomain(updateUserDTO)));
    }
}
