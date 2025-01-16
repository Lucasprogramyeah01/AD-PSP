package com.example.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaPedidoPK {

    private Pedido pedido;

    private Long id;

}
