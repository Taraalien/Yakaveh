package com.kurdsoft.yakaveh.User;

import com.kurdsoft.yakaveh.basket.Basket;
import com.kurdsoft.yakaveh.basket.BasketDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO userDTO);
    UserDTO toUerDto(User User);

    List<User> toUserList(List<UserDTO> userDTOS);
    List<UserDTO> toUserDtos(List<User> users);
}
