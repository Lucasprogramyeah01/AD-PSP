package com.example.monumentosV2.models;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Builder
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
