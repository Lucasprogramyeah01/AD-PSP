package com.example.data.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@IdClass(LineaPedidoPK.class)
public class LineaPedido {

    @Id
    @GeneratedValue
    private Long id;

    @Id
    @ManyToOne
    private Producto producto;

    private int cantidad;

    private double precioVenta;


}
