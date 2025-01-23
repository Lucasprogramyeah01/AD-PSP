package com.example.ejercicioHerencia.joined;

import com.example.ejercicioHerencia.joined.model.Libro;
import com.example.ejercicioHerencia.joined.model.Manga;
import com.example.ejercicioHerencia.joined.repository.LibroRepository;
import com.example.ejercicioHerencia.joined.repository.MangaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataSeedJoined {

    private final LibroRepository libroRepository;
    private final MangaRepository mangaRepository;

    @PostConstruct
    public void run(){

        Libro l1 = Libro.builder()
                .nombre("La grieta del silencio")
                .numPaginas(300)
                .autor("Javier Castillo")
                .build();

        Libro l2 = Libro.builder()
                .nombre("Don Quijote de la Mancha")
                .numPaginas(750)
                .autor("Miguel de Cervantes")
                .build();

        libroRepository.save(l1);
        libroRepository.save(l2);

        Manga m1 = Manga.builder()
                .nombre("Jujutsu Kaisen v30")
                .numPaginas(250)
                .autor("Gege Akutami")
                .numPaneles(3200)
                .build();

        Manga m2 = Manga.builder()
                .nombre("Jojo's Bizarre Adventure: Steel Ball Run v7")
                .numPaginas(540)
                .autor("Hirohiko Araki")
                .numPaneles(4700)
                .build();

        mangaRepository.save(m1);
        mangaRepository.save(m2);

    }
}
