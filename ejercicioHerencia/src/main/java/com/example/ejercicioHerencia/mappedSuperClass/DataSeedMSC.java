package com.example.ejercicioHerencia.mappedSuperClass;

import com.example.ejercicioHerencia.mappedSuperClass.model.Camara;
import com.example.ejercicioHerencia.mappedSuperClass.model.DetectorCalor;
import com.example.ejercicioHerencia.mappedSuperClass.repository.CamaraRepository;
import com.example.ejercicioHerencia.mappedSuperClass.repository.DetectorCalorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataSeedMSC {

    private final CamaraRepository camaraRepository;
    private final DetectorCalorRepository detectorCalorRepository;

    @PostConstruct
    public void run(){

        Camara c1 = Camara.builder()
                .nombre("Camera R1")
                .fabricante("CaptureBetter")
                .precio(200)
                .peso(1)
                .capResolucion(12)
                .tipoBateria("Duracell")
                .build();

        Camara c2 = Camara.builder()
                .nombre("CAMERA-MAN")
                .fabricante("OhFlash")
                .precio(4000)
                .peso(0.8)
                .capResolucion(15)
                .tipoBateria("Patona")
                .build();

        camaraRepository.save(c1);
        camaraRepository.save(c2);

        DetectorCalor d1 = DetectorCalor.builder()
                .nombre("A1")
                .fabricante("DeviceGo")
                .precio(30)
                .minTemperatura(25)
                .maxTemperatura(135)
                .tension(30)
                .build();

        DetectorCalor d2 = DetectorCalor.builder()
                .nombre("B2")
                .fabricante("DeviceGo")
                .precio(54)
                .minTemperatura(30)
                .maxTemperatura(140)
                .tension(12)
                .build();

        detectorCalorRepository.save(d1);
        detectorCalorRepository.save(d2);
    }
}
