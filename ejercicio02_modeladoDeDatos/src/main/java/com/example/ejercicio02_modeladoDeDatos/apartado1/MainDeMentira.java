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
    public void init(){

        Categoria c = Categoria.builder()
                .nombre("Alimentación")
                .build();

        Categoria c2 = Categoria.builder()
                .nombre("Verde")
                .categoria(c)
                .build();

        Categoria c3 = Categoria.builder()
                .nombre("Líquido")
                .build();

        categoriaRepository.save(c);
        categoriaRepository.save(c2);
        categoriaRepository.save(c3);

        Producto p = Producto.builder()
                .nombre("Lechuga")
                .pvp(2.30)
                .categoria(c)
                .build();

        productoRepository.save(p);

    }

}
