package com.example.data.dto;

import com.example.data.model.Alumno;

public record GetAlumnoDTO(
        Long id,
        String nombre,
        String apellidos,
        GetTutorDTO tutor
) {

    public static GetAlumnoDTO fromDTO(Alumno a) {
        return new GetAlumnoDTO(
                a.getId(),
                a.getNombre(),
                a.getApellidos(),
                GetTutorDTO.of(a.getTutor())
        );
    }

}
