package com.api.ligeirinho.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DriverRegisterDto(

    @NotBlank(message = "name is required")
    String name,

    @NotBlank(message = "phone is required")
    String phone,

    @Email(message = "Invalid email")
    String email,

    CarRegisterDto car

) {
}
