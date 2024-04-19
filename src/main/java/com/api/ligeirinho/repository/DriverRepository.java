package com.api.ligeirinho.repository;

import com.api.ligeirinho.domain.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    boolean existsByCarPlate(String plate);
}
