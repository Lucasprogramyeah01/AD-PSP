package com.example.ejercicio02_modeladoDeDatos.apartado1.repository;

import com.example.ejercicio02_modeladoDeDatos.apartado1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
