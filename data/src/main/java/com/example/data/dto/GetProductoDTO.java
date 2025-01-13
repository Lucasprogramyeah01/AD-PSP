package com.example.data.dto;

import com.example.data.model.Producto;

public record GetProductoDTO(
        Long id,
        String nombre,
        double precio,
        GetCategoriaDto categroia
) {

    public static GetProductoDTO of(Producto p){
        return new GetProductoDTO(
                p.
        )
    }

}
