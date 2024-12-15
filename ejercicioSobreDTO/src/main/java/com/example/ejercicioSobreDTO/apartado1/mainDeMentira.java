package com.example.ejercicioSobreDTO.apartado1;

import com.example.ejercicioSobreDTO.apartado1.dto.AlumnoDTO;
import com.example.ejercicioSobreDTO.apartado1.models.Alumno;
import com.example.ejercicioSobreDTO.apartado1.models.Curso;
import com.example.ejercicioSobreDTO.apartado1.models.Direccion;
import jakarta.annotation.PostConstruct;

public class mainDeMentira {

    @PostConstruct
    public void init(){

        //Curso 1.
        Curso c = new Curso(1L, "Cuarto", "ESO", "Carlos Boinas Flores", 202);

        //Dirección 1.
        Direccion d = new Direccion(1L, "Calle", "Bosque de Zamudio, 48E", "5ºB",
        32001, 36240, "Teruel");

        //Alumno 1: Alfonso María Pérez Filomena.
        Alumno a = Alumno.builder()
                .id(1L)
                .nombre("Alfonso María")
                .apellido1("Pérez")
                .apellido2("Filomena")
                .telefono("978619900")
                .email("fonsiMari@gmail.com")
                .direccion(d)
                .curso(c)
        .build();

        //Pasamos de Alumno a AlumnoDTO.
        AlumnoDTO aDTO = AlumnoDTO.toAlumnoDTO(a);
    }
}
