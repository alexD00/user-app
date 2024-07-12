package com.alex.user.service;

import com.alex.user.dto.UserRequestDTO;
import com.alex.user.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequest);

    UserResponseDTO getUserById(Integer userId);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(Integer userId, UserRequestDTO userRequest);

    String deleteUser(Integer userId);
}
