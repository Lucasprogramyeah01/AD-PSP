package com.example.data.dto;

import com.example.data.model.Tutor;

public record GetTutorDTO(
        Long id,
        String nombre,
        String apellidos
) {

    public static GetTutorDTO of(Tutor t) {
        return new GetTutorDTO(
                t.getId(),
                t.getNombre(),
                t.getApellidos()
        );
    }

}
