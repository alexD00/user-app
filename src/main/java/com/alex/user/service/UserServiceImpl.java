package com.alex.user.service;

import com.alex.user.dto.UserRequestDTO;
import com.alex.user.dto.UserResponseDTO;
import com.alex.user.entity.User;
import com.alex.user.mapper.UserMapper;
import com.alex.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequest) {
        User user = new User(
                userRequest.id(),
                userRequest.firstName(),
                userRequest.lastName(),
                userRequest.email(),
                LocalDateTime.now()
        );

        userRepository.save(user);

        return userMapper.toUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO getUserById(Integer userId) {
        return userRepository.findById(userId)
                .map(userMapper::toUserResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Did not find user with id: " + userId));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponseDTO)
                .toList();
    }

    @Override
    public UserResponseDTO updateUser(Integer userId, UserRequestDTO userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Did not find user with id: " + userId));

        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setEmail(userRequest.email());

        userRepository.save(user);

        return userMapper.toUserResponseDTO(user);
    }

    @Override
    public String deleteUser(Integer userId) {
        if (userRepository.findById(userId).isEmpty()){
            throw new EntityNotFoundException("Did not find user with id: " + userId);
        }

        userRepository.deleteById(userId);

        return "Deleted user with id: " + userId;
    }

}
