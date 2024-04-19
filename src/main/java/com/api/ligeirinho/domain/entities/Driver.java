package com.api.ligeirinho.domain.entities;

import com.api.ligeirinho.domain.enums.Status;
import com.api.ligeirinho.dto.DriverRegisterDto;
import com.api.ligeirinho.dto.DriverUpdateDto;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "driver")
@Entity(name = "Driver")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private Car car;

    public Driver(DriverRegisterDto dados) {
    this.name = dados.name();
    this.phone = dados.phone();
    this.email = dados.email();
    this.status = Status.AGUARDANDO;
    this.car = new Car(dados.car());
    }
    public void update(DriverUpdateDto dados) {
        if(dados.name() != null) this.name = dados.name();
        if(dados.phone() != null) this.phone = dados.phone();
        if(dados.email() != null) this.email = dados.email();
        if(dados.car() != null) this.car = new Car(dados.car());
    }
}
