package com.example.data.service;

import com.example.data.model.Categoria;
import com.example.data.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        List<Categoria> listaCategorias = categoriaRepository.findAll();

        if(listaCategorias.isEmpty()){
            throw new EntityNotFoundException("No hay categorías disponibles.");
        }

        return listaCategorias;
    }

    public Categoria findById(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado ninguna categoría con ID: "+id+" ."));
    }

    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria edit(Categoria categoria, Long id){
        return categoriaRepository.findById(id)
            .map(old -> {
                old.setNombre(categoria.getNombre());
                return categoriaRepository.save(old);
            })
            .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado ninguna categoría con ID: "+id+" ."));
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }
}
