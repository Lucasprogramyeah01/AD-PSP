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
public class Alumno {

    @Id
    private Long id;

    private String nombre;

    private String apellido1;

    private String apellido2;

    private String telefono;

    private String email;

    private Direccion direccion;

    private Curso curso;
}
