package com.api.ligeirinho.domain.entities;

import com.api.ligeirinho.dto.CarRegisterDto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String plate;

    private String color;

    private String model;

    private int number_passengers;

    private int capacity;

    public Car(String plate, String color, String model, int capacity) {
        this.plate = plate;
        this.color = color;
        this.model = model;
        this.capacity = capacity;
    }
    public Car(CarRegisterDto dados) {
        this.plate = dados.plate();
        this.color = dados.color();
        this.model = dados.model();
        this.capacity = dados.capacity();
        this.number_passengers = 0;

    }

    public void addPassengers(int number) {
        if (number + number_passengers > capacity){
            throw new IllegalArgumentException("Capacity exceeded");
        }
        this.number_passengers += number;
    }



}
