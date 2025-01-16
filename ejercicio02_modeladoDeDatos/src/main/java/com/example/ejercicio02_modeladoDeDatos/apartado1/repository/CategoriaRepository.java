package com.example.ejercicio02_modeladoDeDatos.apartado1.repository;

import com.example.ejercicio02_modeladoDeDatos.apartado1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
