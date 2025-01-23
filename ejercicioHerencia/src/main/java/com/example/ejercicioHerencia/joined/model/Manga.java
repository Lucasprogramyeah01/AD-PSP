package com.example.ejercicioHerencia.joined.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity
public class Manga extends Libro{

    private int numPaneles;

}
