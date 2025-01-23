package com.example.ejercicioHerencia.singleTable.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Persona {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String apellidos;

    private double altura;

    private double peso;

    private String grupoSanguineo;
}
