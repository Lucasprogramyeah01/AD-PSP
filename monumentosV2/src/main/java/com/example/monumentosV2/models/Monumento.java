package com.example.monumentosV2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 2)
    private String codPais;

    private String nombrePais;

    private String nombreCiudad;

    private double longitud;

    private double latitud;

    private String nombreMonumento;

    @Lob
    private String descripcion;

    @Lob
    private String URLimagen;
}
