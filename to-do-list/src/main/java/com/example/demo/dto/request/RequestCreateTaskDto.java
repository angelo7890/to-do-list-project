package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCreateTaskDto(
        @NotBlank
        @NotNull
        String title,
        @NotBlank
        @NotNull
        String description) {
}
