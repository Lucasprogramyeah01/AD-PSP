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

    //Editar monumento.
    public void editarMonumento(int id){
        Optional<Monumento> encontrado = buscarMonumentoPorID(id);

        if(encontrado.isPresent()){
            monumentoRepository.save(encontrado.get());
        }
    }

    //Borrar monumento por ID.
    public void borrarMonumento(int id){
        monumentoRepository.deleteById(id);
    }

}

//EN LA CLASE InitData tienen las anotaciones en @Component y en su método @Post construct.