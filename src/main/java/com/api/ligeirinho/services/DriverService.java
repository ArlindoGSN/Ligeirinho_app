package com.api.ligeirinho.services;

import com.api.ligeirinho.dto.DriverDetailsDto;
import com.api.ligeirinho.dto.DriverRegisterDto;
import com.api.ligeirinho.dto.DriverUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DriverService {

    DriverDetailsDto save(DriverRegisterDto driver);

    public Page<DriverDetailsDto> findAllDrivers(Pageable page);

    DriverDetailsDto findById(Long id);

    DriverDetailsDto update(Long id, DriverUpdateDto dto);

    void deleteById(Long id);
}
