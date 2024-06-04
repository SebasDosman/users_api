package co.com.dosman.users.mappers;

import java.util.List;
import java.util.stream.Collectors;

import co.com.dosman.common.entities.User;
import co.com.dosman.users.dto.CreateUserDTO;
import co.com.dosman.users.dto.GetUserDTO;
import co.com.dosman.users.dto.UpdateUserDTO;


public class UserMapper {
    public static GetUserDTO modelToGetUserDto(User user) {
        return GetUserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static List<GetUserDTO> modelToGetUserDto(List<User> users) {
        return users.stream().map(UserMapper::modelToGetUserDto).collect(Collectors.toList());
    }

    public static User updateUserDtoToModel(UpdateUserDTO updateUserDTO) {
        return User.builder()
                .id(updateUserDTO.getId())
                .name(updateUserDTO.getName())
                .lastName(updateUserDTO.getLastName())
                .age(updateUserDTO.getAge())
                .email(updateUserDTO.getEmail())
                .password(updateUserDTO.getPassword())
                .build();
    }

    public static User createUserDtoToModel(CreateUserDTO createUserDTO) {
        return User.builder()
                .name(createUserDTO.getName())
                .lastName(createUserDTO.getLastName())
                .age(createUserDTO.getAge())
                .email(createUserDTO.getEmail())
                .password(createUserDTO.getPassword())
                .build();
    }
}
