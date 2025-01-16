package com.example.data;

import com.example.data.model.Categoria;
import com.example.data.model.Pedido;
import com.example.data.model.Producto;
import com.example.data.repository.CategoriaRepository;
import com.example.data.repository.PedidoRepository;
import com.example.data.repository.ProductoRepository;
import com.example.data.repository.TagRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final TagRepository tagRepository;
    private final PedidoRepository pedidoRepository;

    @PostConstruct
    public void run() {

        //Categoria c = categoriaRepository.getReferenceById(1L);
        /*Categoria c = null;
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(1L);

        if (optionalCategoria.isPresent()) {
            c = optionalCategoria.get();
        }

        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precio(123.45)
                //.categoria(c)
                .build();

        c.addProducto(p);

        productoRepository.save(p);

        System.out.println("Productos de la categoria C1");
        System.out.println(c.getProductos());

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .descripcion("Verás como tiene ID 3")
                .precio(234.56)
                .categoria(c)
                .build();

        productoRepository.saveAll(List.of(p, p2));


        productoRepository.findAll()
                .forEach(System.out::println);

    */

        //productoRepository.findAll().forEach(System.out::println);

        Pedido pedido = Pedido.builder()
                .cliente("Luismi")
                .build();

        pedidoRepository.save(pedido);

        pedidoRepository.findAll()
                .forEach(p -> {
                    System.out.println(p.toString());
                    System.out.println();

                });

    }

}
