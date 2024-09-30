package com.salesianostriana.dam.monumentos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue
    public int id;

    public String codPais;

    public String pais;

    public String ciudad;

    public String longitud;

    public String latitud;

    public  String nombre;

    @Lob
    public String descripcion;

    @Lob
    public String URLImagen;

}
