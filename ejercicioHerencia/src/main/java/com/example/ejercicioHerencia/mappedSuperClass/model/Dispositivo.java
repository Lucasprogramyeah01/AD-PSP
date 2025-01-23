package com.example.ejercicioHerencia.mappedSuperClass.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class Dispositivo {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    private String nombre;

    private String fabricante;

    private int precio;

}
