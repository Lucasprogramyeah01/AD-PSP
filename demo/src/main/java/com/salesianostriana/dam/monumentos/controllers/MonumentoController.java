package com.salesianostriana.dam.monumentos.controllers;

import com.salesianostriana.dam.monumentos.models.Monumento;
import com.salesianostriana.dam.monumentos.services.MonumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/v1/monumentos")
public class MonumentoController {

    @Autowired
    private MonumentoService monumentoService;

    //OBTENER LISTA DE MONUMENTOS
    @GetMapping
    public List<Monumento> obtenerListaMonumentos(){
       return monumentoService.obtenerListaMonumentos();
    }

    //EDITAR MONUMENTO
    @PostMapping
    public void editarMonumento(Monumento monumento){
        monumentoService.editarMonumento(monumento);
    }

    //BORRAR MONUMENTO POR ID
    @DeleteMapping("/borrarMonumento/{id}")
    public void borrarMonumentoPorID(@PathVariable("id") int id){
        monumentoService.borrarMonumento(id);
    }

    //BUSCAR MONUMENTO POR ID
    @GetMapping("/{id}")
    public Optional<Monumento> buscarMonumentoPorID(@PathVariable("id") int id){
       return monumentoService.buscarMonumentoPorID(id);
    }







}
