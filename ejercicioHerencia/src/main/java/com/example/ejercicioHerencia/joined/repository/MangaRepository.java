package com.example.ejercicioHerencia.joined.repository;

import com.example.ejercicioHerencia.joined.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga, Long> {
}
