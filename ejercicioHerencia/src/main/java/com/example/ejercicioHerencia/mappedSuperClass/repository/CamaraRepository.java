package com.example.ejercicioHerencia.mappedSuperClass.repository;

import com.example.ejercicioHerencia.mappedSuperClass.model.Camara;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamaraRepository extends JpaRepository<Camara, Long> {

}
