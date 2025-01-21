package com.example.ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Estacion {

    @Id
    @GeneratedValue
    private Long id;

    private Long numero;

    private String nombre;

    private String coordenadas;

    private int capacidad;

    //ASOCIACIÓN CON USO (1E - MU)

    @OneToMany(mappedBy = "estacion", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Uso> usos = new ArrayList<>();

    //ASOCIACIÓN CON BICICLETA (1E - MB)

    @OneToMany(mappedBy = "estacion", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Bicicleta> bicicletas = new ArrayList<>();

    //Métodos Helper (Con Uso)

        public void addUso (Uso u){
            u.setEstacion(this);
            this.usos.add(u);
        }

        public void removeUso (Uso u){
            this.usos.remove(u);
            u.setEstacion(this);
        }

    //Métodos Helper (Con Bicicleta)

        public void addBicicleta (Bicicleta b){
            b.setEstacion(this);
            this.bicicletas.add(b);
        }

        public void removeBicicleta (Bicicleta b){
            this.bicicletas.remove(b);
            b.setEstacion(this);
        }



}
