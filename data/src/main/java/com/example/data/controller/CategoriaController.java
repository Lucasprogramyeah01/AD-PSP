package com.example.data.controller;

import com.example.data.dto.GetCategoriaDto;
import com.example.data.model.Categoria;
import com.example.data.service.CategoriaService;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Builder
@RestController
@RequestMapping("/categoria/")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<GetCategoriaDto> getAll() {
        return categoriaService.findAll().stream().map(GetCategoriaDto::of).toList();
    }

    @GetMapping("/{id}")
    public Categoria getByID(@PathVariable Long id){
        return categoriaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria c){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(c));
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable("id") Long id, @RequestBody Categoria c) {
        return categoriaService.edit(c, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
