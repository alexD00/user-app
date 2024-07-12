package com.alex.user.mapper;

import com.alex.user.dto.UserResponseDTO;
import com.alex.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserResponseDTO toUserResponseDTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

//    public User toUser(UserRequestDTO userRequestDTO){
//        return new User(
//                userRequestDTO.id(),
//                userRequestDTO.firstName(),
//                userRequestDTO.lastName(),
//                userRequestDTO.email(),
//
//        )
//    }
}
