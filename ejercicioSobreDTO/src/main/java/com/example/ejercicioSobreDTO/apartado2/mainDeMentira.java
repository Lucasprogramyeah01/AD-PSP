package com.example.ejercicioSobreDTO.apartado2;

import com.example.ejercicioSobreDTO.apartado2.dto.ProductoDTO;
import com.example.ejercicioSobreDTO.apartado2.models.Categoria;
import com.example.ejercicioSobreDTO.apartado2.models.Producto;
import jakarta.annotation.PostConstruct;

import java.util.Arrays;

public class mainDeMentira {

    @PostConstruct
    public void init(){

        //Categoría 1: Legumbres.
        Categoria c = new Categoria(1L, "Legumbres");

        //Producto 1: Lentejas.
        Producto p = Producto.builder()
                .id(1L)
                .nombre("Lentejas")
                .desc("Si quieres las comes y si no, las dejas.")
                .pvp(1.80)
                .imagenes(Arrays.asList("https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/202403/06/00118007700869____4__600x600.jpg"))
                .categoria(c)
        .build();

        //Pasamos de Producto a ProductoDTO.
        ProductoDTO pDTO = ProductoDTO.toProductDTO(p);
    }

}
