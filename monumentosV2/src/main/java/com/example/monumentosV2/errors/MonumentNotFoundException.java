package com.example.monumentosV2.errors;

public class MonumentNotFoundException extends RuntimeException {

    //Para cuando un ID no se ha encontrado.
    public MonumentNotFoundException(Long id) {
      super("No existe ningún monumento con ese ID: %d".formatted(id));
    }

    //Dependiendo del error, se le pasa un mensaje y se muestra por pantalla.
    public MonumentNotFoundException(String msg) {
      super(msg);
    }

    //Para cuando se buscan monumentos por criterios de búsqueda y no se encuentran.
    public MonumentNotFoundException() {
      super("No hay monumentos con dichos requisitos de búsqueda.");
    }

}
