package com.example.data.controller;

import com.example.data.dto.EditProductoCmd;
import com.example.data.service.ProductoService;
import com.example.data.model.Producto;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Builder
@RestController
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping //ACTUALIZAR MÉT0DO INCLUYENDO EL PRODUCTO DTO.
    public List<Producto> getAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto getByID(@PathVariable Long id){
        return productoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody EditProductoCmd editProductoCmd) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(editProductoCmd));
    }

    @PutMapping("/{id}")
    public Producto updateMonument(@PathVariable("id") Long id, @RequestBody EditProductoCmd editProductoCmd) {
        return productoService.edit(editProductoCmd, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteMonument(@PathVariable("id") Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
