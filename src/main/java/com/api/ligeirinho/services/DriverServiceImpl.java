package com.api.ligeirinho.services;

import com.api.ligeirinho.domain.entities.Driver;
import com.api.ligeirinho.dto.DriverDetailsDto;
import com.api.ligeirinho.dto.DriverRegisterDto;
import com.api.ligeirinho.dto.DriverUpdateDto;
import com.api.ligeirinho.repository.DriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    DriverRepository repository;

    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<DriverDetailsDto> findAllDrivers(Pageable page) {
        return repository.findAll(page).map(DriverDetailsDto::new);
    }

    @Override
    public DriverDetailsDto save(DriverRegisterDto driver) {
        var myDriver = repository.save(new Driver(driver));
        return new DriverDetailsDto(myDriver);
    }
    @Override
    public DriverDetailsDto findById(Long id){

        var driver = repository.findById(id).orElseThrow(() -> new RuntimeException("id: '%s'  not found ".formatted(id)));

            if (driver != null) {
            return new DriverDetailsDto(driver);
        } else {
            throw new RuntimeException("Driver not found");
            }
    }
    @Override
    public DriverDetailsDto update(Long id, DriverUpdateDto dto) {

        var driver = repository.findById(id).orElseThrow(() -> new RuntimeException("id: '%s'  not found ".formatted(id)));

        if(repository.existsByCarPlate(dto.car().plate())){
            throw new IllegalArgumentException("Car plate already exists");
        }

        driver.update(dto);
        return new DriverDetailsDto(driver);
    }
    @Override
    public void deleteById(Long id) {
        var driver = repository.findById(id).orElseThrow(() -> new RuntimeException("id: '%s'  not found ".formatted(id)));
        repository.delete(driver);
    }
}
