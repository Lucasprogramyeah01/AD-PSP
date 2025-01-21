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
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private Long numTarjeta;

    private int pin;

    private double saldo;

    //ASOCIACIÓN CON USO (1U - MU)

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Uso> usos = new ArrayList<>();

    //Métodos Helper (Con Uso)

        public void addUso (Uso u){
            u.setUsuario(this);
            this.usos.add(u);
        }

        public void removeUso (Uso u){
            this.usos.remove(u);
            u.setUsuario(null);
        }


}
