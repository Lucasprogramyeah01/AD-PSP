package com.example.ejercicioHerencia.joined.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity
public class Libro {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private int numPaginas;

    private String autor;
}
