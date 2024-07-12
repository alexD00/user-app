package com.alex.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        Integer id,

        @NotBlank
        @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
        String firstName,

        @NotBlank
        @Size(min = 2, max = 40, message = "Last name must be between 2 and 30 characters")
        String lastName,

        @NotBlank
        @Email
        String email
) {
}
