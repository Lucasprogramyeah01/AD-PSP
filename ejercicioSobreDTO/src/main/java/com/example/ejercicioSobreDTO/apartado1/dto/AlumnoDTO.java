package com.example.ejercicioSobreDTO.apartado1.dto;

import com.example.ejercicioSobreDTO.apartado1.models.Alumno;

public record AlumnoDTO(
        String nombre,
        String apellidos,
        String email,
        String curso,
        String direccion
) {

    public static AlumnoDTO toAlumnoDTO (Alumno alumno){
        return new AlumnoDTO(
            alumno.getNombre(),
            alumno.getApellido1() + "" + alumno.getApellido2(),
            alumno.getEmail(),
            alumno.getCurso().getNombre() + " " + alumno.getCurso().getTipo(),
            alumno.getDireccion().getTipoVia() + " " + alumno.getDireccion().getLinea1() + ", " + alumno.getDireccion().getLinea2()
        );
    }

}
