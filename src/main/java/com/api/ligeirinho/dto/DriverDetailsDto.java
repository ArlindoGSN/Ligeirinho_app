package com.api.ligeirinho.dto;

import com.api.ligeirinho.domain.entities.Driver;

public record DriverDetailsDto(
        Long id,
        String name,
        String phone,
        String email
) {
    public DriverDetailsDto(Driver myDriver) {
        this(myDriver.getId(), myDriver.getName(), myDriver.getPhone(), myDriver.getEmail());
    }
}
