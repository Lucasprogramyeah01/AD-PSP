package com.example.monumentosV2.controllers;

import com.example.monumentosV2.models.Monumento;
import com.example.monumentosV2.services.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
@Tag(name = "Monumento", description = "Controlador de Monumentos, para poder realizar sus operaciones de gestión.")
public class MonumentoController {

    private final MonumentoService monumentoService;

    @Operation(summary = "Obtiene una lista de todos los monumentos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado monumentos.",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": 1,
                                                    "codPais": "ES",
                                                    "nombrePais": "España",
                                                    "nombreCiudad": "Bilbao",
                                                    "longitud": -2.92528,
                                                    "latitud": 43.26271,
                                                    "nombreMonumento": "Puppy",
                                                    "descripcion": "Es una icónica escultura floral moderna con
                                                        forma de cachorro realizada por el artista estadounidense 
                                                        Jeff Koons en 1992 que está ubicada frente al Museo Guggenheim.",
                                                    "URLImagen": "https://cms.guggenheim-bilbao.eus/uploads/2021/03/Jeff-Koons-Puppy-1992.jpg"
                                                },
                                                {
                                                    "id": 2, 
                                                    "codPais": "ES", 
                                                    "nombrePais": "España",
                                                    "nombreCiudad": "Sevilla",
                                                    "longitud": -5.97317,
                                                    "latitud": 37.38283,
                                                    "nombreMonumento": "Giralda",
                                                    "descripcion": "Es la torre campanario de la catedral de Santa 
                                                        María de la Sede de la ciudad de Sevilla. La parte inferior 
                                                        de la torre corresponde al alminar de la antigua mezquita de 
                                                        la ciudad, de finales del siglo XII, levantado en época 
                                                        almohade, mientras que la parte superior es una construcción 
                                                        sobrepuesta en el siglo XVI, en época cristiana, para albergar 
                                                        el cuerpo de campanas.",
                                                    "URLImagen": "https://www.guiasevilla.com/f/espana/sevilla/guia/giralda-m.jpg"
                                                },
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado monumentos.",
                    content = @Content),
    })
    @GetMapping
    public List<Monumento> getAllMonuments() {
        return monumentoService.getAllMonuments();
    }

    @Operation(summary = "Obtiene un monumento buscado por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el monumento buscado.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Monumento.class),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": 1,
                                                "codPais": "ES",
                                                "nombrePais": "España",
                                                "nombreCiudad": "Bilbao",
                                                "longitud": -2.92528,
                                                "latitud": 43.26271,
                                                "nombreMonumento": "Puppy",
                                                "descripcion": "Es una icónica escultura floral moderna con 
                                                    forma de cachorro realizada por el artista estadounidense 
                                                    Jeff Koons en 1992 que está ubicada frente al Museo Guggenheim.",
                                                "URLImagen": "https://cms.guggenheim-bilbao.eus/uploads/2021/03/Jeff-Koons-Puppy-1992.jpg"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado el monumento buscado.",
                    content = @Content),
    })
    @GetMapping("/{id}")
    public Monumento getMonumentById(@PathVariable Long id) {
        return monumentoService.getMonumentById(id);
    }

    @Operation(summary = "Crea un nuevo monumento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha creado el monumento correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Monumento.class),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": 6,
                                                "codPais": "DK",
                                                "nombrePais": "Dinamarca (Groenlandia)",
                                                "nombreCiudad": "Nuuk",
                                                "longitud": -51.72157,
                                                "latitud": 64.18347,
                                                "nombreMonumento": "Estatua de Hans Egede",
                                                "descripcion": "Es un monumento destacado en la ciudad de Nuuk, la 
                                                    capital de la isla y territorio de Groenlandia, una dependencia 
                                                    autónoma de Dinamarca. Conmemora la labor del misionero luterano 
                                                    de origen danés y noruego Hans Egede que fundó Nuuk en el año 
                                                    1728.",
                                                "urlimagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Egede_nuuk.JPG/320px-Egede_nuuk.JPG"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha creado el monumento.",
                    content = @Content),
    })
    @PostMapping
    public ResponseEntity<Monumento> createMonument(@RequestBody Monumento m) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(monumentoService.addMonument(m));
    }

    @Operation(summary = "Edita un monumento ya creado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha editado el monumento correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Monumento.class),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": 1,
                                                "codPais": "ES",
                                                "nombrePais": "España",
                                                "nombreCiudad": "Bilbao",
                                                "longitud": -2.92528,
                                                "latitud": 43.26271,
                                                "nombreMonumento": "Cachorrito de flores",
                                                "descripcion": "Es una icónica escultura floral moderna con forma de 
                                                    cachorro realizada por el artista estadounidense Jeff Koons en 
                                                    1992 que está ubicada frente al Museo Guggenheim.",
                                                "urlimagen": "https://cms.guggenheim-bilbao.eus/uploads/2021/03/Jeff-Koons-Puppy-1992.jpg"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado el monumento.",
                    content = @Content),
    })
    @PutMapping("/{id}")
    public Monumento updateMonument(@PathVariable("id") Long id, @RequestBody Monumento m) {
        return monumentoService.editMonument(id, m);
    }

    @Operation(summary = "Borra un monumento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Se ha borrado el monumento correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Monumento.class)
                    )}),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Monumento> deleteMonument(@PathVariable("id") Long id) {
        monumentoService.deleteMonument(id);
        return ResponseEntity.noContent().build();
    }

}