package com.api.ligeirinho.dto;

import com.api.ligeirinho.domain.entities.Driver;

public record DriverUpdateDto(
    String name,
    String phone,
    String email,
    CarRegisterDto car

) {

}
