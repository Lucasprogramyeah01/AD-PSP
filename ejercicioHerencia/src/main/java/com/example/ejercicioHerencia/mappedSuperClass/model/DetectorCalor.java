package com.example.ejercicioHerencia.mappedSuperClass.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class DetectorCalor extends Dispositivo{

    private int minTemperatura;

    private int maxTemperatura;

    private int tension;

}
