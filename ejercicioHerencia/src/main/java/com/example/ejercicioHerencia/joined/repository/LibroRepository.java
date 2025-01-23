package com.example.ejercicioHerencia.joined.repository;

import com.example.ejercicioHerencia.joined.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
