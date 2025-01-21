package com.example.ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Uso {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private double coste;

    @ManyToOne
    @JoinColumn(name = "usuario_id",
        foreignKey = @ForeignKey(name = "fk_uso_usuario")
    )
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id",
        foreignKey = @ForeignKey(name = "fk_uso_bicicleta")
    )
    private Bicicleta bicicleta;

    @ManyToOne
    @JoinColumn(name = "estacion_id",
        foreignKey = @ForeignKey(name = "fk_uso_estacion")
    )
    private Estacion estacion;
}
