package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCreateUserDto(
        @NotBlank
        @NotNull
        String name,
        @NotBlank
        @NotNull
        String email,
        @NotBlank
        @NotNull
        String password
) {
}
