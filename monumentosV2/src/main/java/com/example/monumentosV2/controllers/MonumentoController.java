package com.example.monumentosV2.controllers;

import com.example.monumentosV2.models.Monumento;
import com.example.monumentosV2.repositories.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentRepository;

    @GetMapping
    public ResponseEntity<List<Monumento>> getAllMonuments() {
        List<Monumento> result = monumentRepository.getAll();

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getMonumentById(@PathVariable Long id) {
        return ResponseEntity.of(
                monumentRepository.findById(id)
        );
    }

    @PostMapping
    public ResponseEntity<Monumento> createMonument(@RequestBody Monumento m) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(monumentRepository.addMonument(m));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> updateMonument(@PathVariable("id") Long id, @RequestBody Monumento m) {
        return ResponseEntity.of(
                monumentRepository.editMonument(id, m)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMonument(@PathVariable("id") Long id) {
        monumentRepository.deleteMonument(id);
        return ResponseEntity.noContent().build();
    }

}