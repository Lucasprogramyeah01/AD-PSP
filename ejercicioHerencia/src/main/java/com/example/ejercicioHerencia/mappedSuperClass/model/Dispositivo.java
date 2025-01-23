package com.example.ejercicioHerencia.mappedSuperClass.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@MappedSuperclass
public abstract class Dispositivo {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String fabricante;

    private int precio;
}
