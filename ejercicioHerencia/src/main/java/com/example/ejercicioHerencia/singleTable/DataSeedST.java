package com.example.ejercicioHerencia.singleTable;

import com.example.ejercicioHerencia.singleTable.model.Hombre;
import com.example.ejercicioHerencia.singleTable.model.Mujer;
import com.example.ejercicioHerencia.singleTable.repository.HombreRepository;
import com.example.ejercicioHerencia.singleTable.repository.MujerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataSeedST {

    private final HombreRepository hombreRepository;
    private final MujerRepository mujerRepository;

    @PostConstruct
    public void run(){

        Hombre h1 = Hombre.builder()
                .nombre("Alfonso María")
                .apellidos("Pérez Filomena")
                .altura(1.90)
                .peso(50)
                .grupoSanguineo("AB")
                .build();

        hombreRepository.save(h1);

        Mujer m1 = Mujer.builder()
                .nombre("Paula")
                .apellidos("Papadopoulos Fernández")
                .altura(1.70)
                .peso(60)
                .grupoSanguineo("0")
                .medidaBusto(75)
                .build();

        mujerRepository.save(m1);
    }
}
