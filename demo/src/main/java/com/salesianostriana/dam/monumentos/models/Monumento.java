package com.salesianostriana.dam.monumentos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codPais;

    private String pais;

    private String ciudad;

    private String longitud;

    private String latitud;

    private  String nombre;

    @Lob
    private String descripcion;

    @Lob
    private String URLImagen;

}
