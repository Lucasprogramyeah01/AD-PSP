package com.example.ejercicio02_modeladoDeDatos.apartado2.repository;

import com.example.ejercicio02_modeladoDeDatos.apartado2.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
