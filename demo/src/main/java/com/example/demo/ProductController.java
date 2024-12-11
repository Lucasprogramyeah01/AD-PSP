package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        /*
        1 - Obtener del repositorio la lista de productos.
        2 - Si la lista está vacía, devolver 404.
        3 - Si la lista tiene productos, devolver 200 con la lista.
         */

        List<Product> result = productRepository.getAll();

        /* Se puede escribir también así:

         var result = productRepository.getAll();

         var significa variable local, y detecta el tipo que debe devolver el método,
         en este caso una lista de productos. */

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.add(product));
    }

}