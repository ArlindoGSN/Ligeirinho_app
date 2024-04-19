package com.api.ligeirinho.services;

import com.api.ligeirinho.domain.entities.Driver;
import com.api.ligeirinho.dto.CarRegisterDto;
import com.api.ligeirinho.dto.DriverDetailsDto;
import com.api.ligeirinho.dto.DriverRegisterDto;
import com.api.ligeirinho.repository.DriverRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DriverServiceImplTest {

    @Test
    void save_And_Return_DriverDetailsDto() {
        // Arrange
        DriverRegisterDto driver = new DriverRegisterDto("John Doe", "1234567890", "john.doe@example.com", new CarRegisterDto("ABC1234", "Camry", "2021",5));
        DriverRepository repository = mock(DriverRepository.class);
        DriverServiceImpl service = new DriverServiceImpl(repository);

        // Act
        DriverDetailsDto result = service.save(driver);

        // Assert
        assertEquals(driver.name(), result.name());
        assertEquals(driver.phone(), result.phone());
        assertEquals(driver.email(), result.email());
        verify(repository, times(1)).save(any(Driver.class));
    }
}