package co.com.dosman.service.usuarios.mappers;

import java.util.List;
import java.util.stream.Collectors;

import co.com.dosman.service.usuarios.dto.*;
import co.com.dosman.service.usuarios.model.User;


public class UserMapper {
    public static GetUserDTO domainToGetUserDto(User user) {
        return GetUserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static List<GetUserDTO> domainToGetUserDto(List<User> users) {
        return users.stream().map(UserMapper::domainToGetUserDto).collect(Collectors.toList());
    }

    public static User updateUserDtoToDomain(UpdateUserDTO updateUserDTO) {
        return User.builder()
                .id(updateUserDTO.getId())
                .name(updateUserDTO.getName())
                .lastName(updateUserDTO.getLastName())
                .age(updateUserDTO.getAge())
                .email(updateUserDTO.getEmail())
                .password(updateUserDTO.getPassword())
                .build();
    }

    public static User createUserDtoToDomain(CreateUserDTO createUserDTO) {
        return User.builder()
                .name(createUserDTO.getName())
                .lastName(createUserDTO.getLastName())
                .age(createUserDTO.getAge())
                .email(createUserDTO.getEmail())
                .password(createUserDTO.getPassword())
                .build();
    }
}
