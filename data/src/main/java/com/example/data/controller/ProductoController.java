package com.example.data.controller;

import com.example.data.dto.EditProductoCmd;
import com.example.data.dto.GetProductoDto;
import com.example.data.service.ProductoService;
import com.example.data.model.Producto;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Builder
@RestController
@RequestMapping("/product/")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<GetProductoDto> getAll() {
        return productoService.findAll().stream().map(GetProductoDto::of).toList();
    }

    @GetMapping("/{id}")
    public Producto getByID(@PathVariable Long id){
        return productoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody EditProductoCmd nuevo) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(nuevo));
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable("id") Long id, @RequestBody EditProductoCmd aEditar) {
        return productoService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
