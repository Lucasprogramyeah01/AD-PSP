package com.example.demo.controller;

import com.example.demo.controller.dto.CreateProductDto;
import com.example.demo.controller.dto.GetProductListDto;
import com.example.demo.model.Product;
import com.example.demo.model.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/product/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    /*@GetMapping
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
         en este caso una lista de productos.

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(result);
        }
    }*/

    @GetMapping
    //public ResponseEntity<List<Product>> getAll(
    public GetProductListDto getAll(
            @RequestParam(required = false, value = "maxPrice", defaultValue = "-1") double max,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection) {

        List<Product> result = productRepository.query(max, sortDirection);

        if (result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se han encontrado productos.");
        }

        return GetProductListDto.of(productService.query(max, sortDirection));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.add(product.toProduct()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id){
        return ResponseEntity.of(productRepository.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long productId, @RequestBody Product product){
        return ResponseEntity.of(productRepository.edit(productId, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id){
        productRepository.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}