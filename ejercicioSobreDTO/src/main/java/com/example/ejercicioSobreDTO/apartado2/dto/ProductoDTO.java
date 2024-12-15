package com.example.ejercicioSobreDTO.apartado2.dto;

import com.example.ejercicioSobreDTO.apartado2.models.Producto;

public record ProductoDTO(
        String nombre,
        double pvp,
        String imagen,
        String categoria
) {

    public static ProductoDTO toProductDTO(Producto producto){
        return new ProductoDTO(
            producto.getNombre(),
            producto.getPvp(),
            producto.getImagenes().get(0),
            producto.getCategoria().getNombre()
        );
    }

}