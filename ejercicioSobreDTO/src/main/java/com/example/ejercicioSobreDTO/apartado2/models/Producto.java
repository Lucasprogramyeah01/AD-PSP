package com.example.ejercicioSobreDTO.apartado2.models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    private Long id;

    private String nombre;

    private String desc;

    private double pvp;

    private List<String> imagenes;

    private Categoria categoria;
}