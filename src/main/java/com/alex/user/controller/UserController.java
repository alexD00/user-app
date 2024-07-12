package com.alex.user.controller;

import com.alex.user.dto.UserRequestDTO;
import com.alex.user.dto.UserResponseDTO;
import com.alex.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{user-id}")
    private ResponseEntity<UserResponseDTO> updateUser(@PathVariable("user-id") Integer userId,
                                                       @RequestBody @Valid UserRequestDTO userRequest){
        return ResponseEntity.ok(userService.updateUser(userId, userRequest));
    }

    @DeleteMapping("/{user-id}")
    private ResponseEntity<String> deleteUser(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

}
