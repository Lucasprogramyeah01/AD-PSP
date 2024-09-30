package com.salesianostriana.dam.monumentos.repositories;

import com.salesianostriana.dam.monumentos.models.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentoRepository extends JpaRepository <Monumento, Integer> {

}
