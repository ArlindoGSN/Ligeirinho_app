package com.api.ligeirinho.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CarRegisterDto(
        @NotBlank(message = "plate is required")
        @Size(min = 7, max = 7, message = "plate must have 7 characters")
        String plate,
        @NotBlank(message = "color is required")
        String color,
        @NotBlank(message = "model is required")
        String model,
        @NotNull(message = "capacity is required")
        @Positive(message = "capacity must be positive")
        int capacity
) {
}