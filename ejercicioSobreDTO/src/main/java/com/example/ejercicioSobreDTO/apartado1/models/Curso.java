package com.example.ejercicioSobreDTO.apartado1.models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Curso {

    @Id
    private Long id;

    private String nombre;

    private String tipo;

    private String tutor;

    private int aula;
}
