package com.salesianostriana.dam.monumentos.services;

import com.salesianostriana.dam.monumentos.models.Monumento;
import com.salesianostriana.dam.monumentos.repositories.MonumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonumentoService {

    @Autowired
    private MonumentoRepository monumentoRepository;

    //Obtener lista de monumentos.
    public List<Monumento> obtenerListaMonumentos(){
        return monumentoRepository.findAll();
    }

    //Buscar monumento por ID.
    public Optional<Monumento> buscarMonumentoPorID(int id){
        return monumentoRepository.findById(id);
    }

    //Agregar monumento.
    public Monumento agregarMonumento(Monumento monumento){
        return monumentoRepository.save(monumento);
    }

    //Editar monumento.
    public Monumento editarMonumento(Monumento monumento, int id){

        Monumento mon = null;
        Optional<Monumento> encontrado = buscarMonumentoPorID(id);

        if(encontrado.isPresent()){
            mon = encontrado.get();
            mon = monumentoRepository.save(monumento);
            return mon;
        }else{
            return null;
        }
    }

    //Borrar monumento por ID.
    public void borrarMonumento(int id){
        monumentoRepository.deleteById(id);
    }

}