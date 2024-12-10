package com.salesianostriana.dam.monumentos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 2)   //Esta columna no puede ser nula y su cadena de caracteres tiene una longitud de 2 caracteres.
    private String codPais;

    private String pais;

    private String ciudad;

    private int longitud;

    private int latitud;

    private  String nombre;

    @Lob
    private String descripcion;

    @Lob
    private String imagen;

}

//En Categoría: @JSONIgnoreProperties("listadoCategorias")
//En Libro: @JSONIgnoreProperties("listadoLibros")