package com.alex.user.dto;

public record UserResponseDTO(
        Integer id,
        String firstName,
        String lastName,
        String email
) {
}
