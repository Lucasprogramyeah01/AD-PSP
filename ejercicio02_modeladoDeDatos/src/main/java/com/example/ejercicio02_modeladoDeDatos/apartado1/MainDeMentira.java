package com.example.ejercicio02_modeladoDeDatos.apartado1;

import com.example.ejercicio02_modeladoDeDatos.apartado1.model.Categoria;
import com.example.ejercicio02_modeladoDeDatos.apartado1.model.Producto;
import com.example.ejercicio02_modeladoDeDatos.apartado1.repository.CategoriaRepository;
import com.example.ejercicio02_modeladoDeDatos.apartado1.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void run(){

        Categoria c = categoriaRepository.getReferenceById(1L);

        Producto p = Producto.builder()
                .nombre("Lechuga")
                .pvp(2.30)
                .categoria(c)
                .build();

        c.addProducto(p);

        productoRepository.save(p);

    }

}
