package com.example.data;

import com.example.data.model.Categoria;
import com.example.data.model.Producto;
import com.example.data.repository.CategoriaRepository;
import com.example.data.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository repoProducto;
    private final CategoriaRepository repoCategoria;

    @PostConstruct
    public void run() {

        Categoria c = null;
        Optional<Categoria> optionalCategoria = repoCategoria.findById(1L);

        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo.")
                .precio(123.45)
                .build();

        repoProducto.save(p);

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .descripcion("Verás cómo tiene ID 3.")
                .precio(123.45)
                .build();

        repoProducto.save(p);
    }



}
