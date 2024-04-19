package com.api.ligeirinho.controllers;

import com.api.ligeirinho.dto.DriverDetailsDto;
import com.api.ligeirinho.dto.DriverRegisterDto;
import com.api.ligeirinho.dto.DriverUpdateDto;
import com.api.ligeirinho.services.DriverServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/drivers")
public class DriverController {


    private final DriverServiceImpl service;

    public DriverController(DriverServiceImpl service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<DriverDetailsDto> registerDriver(@Valid @RequestBody DriverRegisterDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<Page<DriverDetailsDto>> getListDrivers(Pageable page) {

        Page<DriverDetailsDto> drivers = service.findAllDrivers(page);
        return ResponseEntity.ok(drivers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DriverDetailsDto> findDriver(@PathVariable Long id){
        var driver = service.findById(id);
        return ResponseEntity.ok(driver);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DriverDetailsDto> updateDriver(@PathVariable Long id, @RequestBody DriverUpdateDto dto){

        return ResponseEntity.ok(service.update(id, dto));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDriver(@PathVariable Long id){
        service.deleteById(id);
    }






}

