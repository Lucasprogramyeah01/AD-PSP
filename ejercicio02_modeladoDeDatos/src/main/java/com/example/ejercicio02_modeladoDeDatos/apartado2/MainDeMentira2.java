package com.example.ejercicio02_modeladoDeDatos.apartado2;

import com.example.ejercicio02_modeladoDeDatos.apartado2.model.CursoOnline;
import com.example.ejercicio02_modeladoDeDatos.apartado2.model.Profesor;
import com.example.ejercicio02_modeladoDeDatos.apartado2.model.Video;
import com.example.ejercicio02_modeladoDeDatos.apartado2.repository.CursoOnlineRepository;
import com.example.ejercicio02_modeladoDeDatos.apartado2.repository.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira2 {

    private final ProfesorRepository profesorRepository;
    private final CursoOnlineRepository cursoOnlineRepository;

    @PostConstruct
    public void init(){

        Profesor p = Profesor.builder()
                .nombre("Khindasvinto Khan")
                .email("khan@gmail.com")
                .puntuacion(7.5)
                .build();

        Profesor p2 = Profesor.builder()
                .nombre("Mia Kreissl")
                .email("austriaMia@gmail.com")
                .puntuacion(10)
                .build();

        profesorRepository.save(p);
        profesorRepository.save(p2);

        CursoOnline ck = CursoOnline.builder()
                .nombre("Tutorial para atarse los zapatos.")
                .puntuacion(9)
                .profesor(p)
                .build();

        CursoOnline cm = CursoOnline.builder()
                .nombre("Tutorial para aprender estadísitica básica.")
                .puntuacion(9)
                .profesor(p2)
                .build();

        Video vk = Video.builder()
                .orden(1)
                .titulo("Como conseguir cordones de zapato.")
                .descripcion("Este vídeo te enseñara a conseguir cordones de la más alta calidad para tus zapatos.")
                .url("ZAPAZAPA1url")
                .cursoOnline(ck)
                .build();

        Video vk2 = Video.builder()
                .orden(2)
                .titulo("Como hacer un nudo básico.")
                .descripcion("Este vídeo te enseñará a realizar nudos básicos.")
                .url("ZAPAZAPA2url")
                .cursoOnline(ck)
                .build();

        Video vm = Video.builder()
                .orden(1)
                .titulo("Media, moda y mediana.")
                .descripcion("Este vídeo te enseñara a realizar los cálculos de la media, la moda y la mediana.")
                .url("ModaMediaMedianaurl")
                .cursoOnline(cm)
                .build();

        cursoOnlineRepository.save(ck);
        cursoOnlineRepository.save(cm);

    }

}
