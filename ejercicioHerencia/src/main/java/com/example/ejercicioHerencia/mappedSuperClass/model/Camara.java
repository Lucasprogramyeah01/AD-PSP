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
public class Camara extends Dispositivo{

    private int peso;

    private int capResolucion;

    private String tipoBateria;

}
