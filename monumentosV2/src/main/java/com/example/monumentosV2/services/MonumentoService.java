package com.example.monumentosV2.services;

import com.example.monumentosV2.models.Monumento;
import com.example.monumentosV2.repositories.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepository monumentoRepository;

    public List<Monumento> getAllMonuments(){
        List<Monumento> result = monumentoRepository.getAll();
        if (result.isEmpty()){
            throw new ProductNotFoundException();
        }else {
            return result;
        }
    }

    /*public List<Monumento> query(double maxPrice, String sortDirection) {
        List<Monumento> result = productRepository.query(maxPrice, sortDirection);
        if (result.isEmpty())
            throw new ProductNotFoundException();
        return result;
    }*/

    public Monumento getMonumentById (Long id) {
        return monumentoRepository.findById(id).get()
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Monumento editMonument (Long id, Monumento newValue) {
        return monumentoRepository.editMonument(id, newValue)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteMonument (Long id) {
        monumentoRepository.deleteMonument(id);
    }

}
