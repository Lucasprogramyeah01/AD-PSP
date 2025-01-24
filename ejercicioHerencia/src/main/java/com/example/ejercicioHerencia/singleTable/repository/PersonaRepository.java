package com.example.ejercicioHerencia.singleTable.repository;

import com.example.ejercicioHerencia.singleTable.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface PersonaRepository<T extends Persona> extends JpaRepository<T, Long> {

}
