package com.example.data.dto;

import com.example.data.model.Categoria;

public record GetCategoriaDto(
        Long id,
        String nombre
) {

    public static GetCategoriaDto of(Categoria categoria) {
        return new GetCategoriaDto(categoria.getId(), categoria.getNombre());
    }

}
