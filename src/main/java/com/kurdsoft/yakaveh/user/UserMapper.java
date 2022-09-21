package com.kurdsoft.yakaveh.user;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO userDTO);
    UserDTO toUerDto(User User);

    List<User> toUserList(List<UserDTO> userDTOS);
    List<UserDTO> toUserDtos(List<User> users);
}
