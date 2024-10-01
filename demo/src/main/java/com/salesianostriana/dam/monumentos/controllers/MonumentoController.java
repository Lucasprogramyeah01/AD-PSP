package com.salesianostriana.dam.monumentos.controllers;

import com.salesianostriana.dam.monumentos.models.Monumento;
import com.salesianostriana.dam.monumentos.services.MonumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/monumentos")
public class MonumentoController {

    @Autowired
    private MonumentoService monumentoService;

    //OBTENER LISTA DE MONUMENTOS
    @GetMapping
    public ResponseEntity<List<Monumento>> obtenerListaMonumentos(){
        return new ResponseEntity<List<Monumento>>(monumentoService.obtenerListaMonumentos(), HttpStatus.OK);
    }

    //EDITAR MONUMENTO
    @PostMapping
    public void editarMonumento(int id){
        monumentoService.editarMonumento(id);
    }

    //BORRAR MONUMENTO POR ID
    @DeleteMapping("/borrarMonumento/{id}")
    public ResponseEntity<Void> borrarMonumentoPorID(@PathVariable("id") int id){
        monumentoService.borrarMonumento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //BUSCAR MONUMENTO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Monumento>> buscarMonumentoPorID(@PathVariable("id") int id){
       return new ResponseEntity<Optional<Monumento>>(monumentoService.buscarMonumentoPorID(id), HttpStatus.OK);
    }







}
