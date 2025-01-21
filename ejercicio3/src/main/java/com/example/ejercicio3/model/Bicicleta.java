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
public class Bicicleta {

    @Id
    @GeneratedValue
    private Long id;

    private String marca;

    private String modelo;

    private String estado;

    @OneToMany(mappedBy = "bicicleta", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Uso> usos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "estacion_id",
        foreignKey = @ForeignKey(name = "fk_bicicleta_estacion")
    )
    private Estacion estacion;

    //Métodos Helper (Con Bicicleta)

        public void addBicicleta (Bicicleta b){
            b.setUsos(this);
            this.bicicletas.add(b);
        }

        public void removeBicicleta (Bicicleta b){
            this.bicicletas.remove(b);
            b.setEstacion(this);
        }
}
