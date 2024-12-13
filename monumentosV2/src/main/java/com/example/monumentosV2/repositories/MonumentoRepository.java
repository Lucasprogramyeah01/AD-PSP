package com.example.monumentosV2.repositories;

import com.example.monumentosV2.models.Monumento;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> listaMonumentos = new HashMap<>();

    @PostConstruct
    public void init() {
        addMonument(Monumento.builder()
                .id(1L)
                .codPais("ES")
                .nombrePais("España")
                .nombreCiudad("Bilbao")
                .longitud(-2.92528).latitud(43.26271)
                .nombreMonumento("Puppy")
                .descripcion("Es una icónica escultura floral moderna con forma de cachorro realizada " +
                        "por el artista estadounidense Jeff Koons en 1992 que está ubicada frente al Museo Guggenheim.")
                .URLimagen("https://cms.guggenheim-bilbao.eus/uploads/2021/03/Jeff-Koons-Puppy-1992.jpg").build());

        addMonument(Monumento.builder()
                .id(2L)
                .codPais("ES")
                .nombrePais("España")
                .nombreCiudad("Sevilla")
                .longitud(-5.97317).latitud(37.38283)
                .nombreMonumento("Giralda")
                .descripcion("Es la torre campanario de la catedral de Santa María de la Sede de la ciudad de Sevilla. " +
                        "La parte inferior de la torre corresponde al alminar de la antigua mezquita de la ciudad, de " +
                        "finales del siglo XII, levantado en época almohade, mientras que la parte superior es una " +
                        "construcción sobrepuesta en el siglo XVI, en época cristiana, para albergar el cuerpo de campanas.")
                .URLimagen("https://www.guiasevilla.com/f/espana/sevilla/guia/giralda-m.jpg").build());

        addMonument(Monumento.builder()
                .id(3L)
                .codPais("NZ")
                .nombrePais("Nueva Zelanda")
                .nombreCiudad("Christchurch")
                .longitud(172.63333).latitud(-43.53333)
                .nombreMonumento("Estatua de Cook")
                .descripcion("Se localiza en la Plaza Victoria, Christchurch, conmemora los tres viajes de James Cook a " +
                        "Nueva Zelanda. La estatua, esculpida por William Trethewey, se dio a conocer el 10 de agosto de " +
                        "1932 por el Gobernador General, Lord Bledisloe.")
                .URLimagen("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Captain_Cook_statue%2C_Christchurch.jpg/640px-Captain_Cook_statue%2C_Christchurch.jpg").build());

        addMonument(Monumento.builder()
                .id(4L)
                .codPais("NO")
                .nombrePais("Noruega")
                .nombreCiudad("Larvik")
                .longitud(10.03517).latitud(59.05328)
                .nombreMonumento("Minnehallen")
                .descripcion("El monumento fue encargado por el Parlamento noruego después de la Primera Guerra Mundial " +
                        "para conmemorar a los marineros noruegos caídos en la guerra. Fue inaugurado por el rey Haakon " +
                        "VII y posteriormente se convirtió en el monumento nacional que conmemora a los marineros caídos " +
                        "tanto en la Primera como en la Segunda Guerra Mundial.")
                .URLimagen("https://i.ytimg.com/vi/zm0GQ2xoTL4/maxresdefault.jpg").build());

    }

    public Monumento addMonument(Monumento m) {
        listaMonumentos.put(m.getId(), m);
        return m;
    }

    public Optional<Monumento> findById(Long id) {
        return Optional.ofNullable(listaMonumentos.get(id));
    }

    public List<Monumento> getAll() {
        return List.copyOf(listaMonumentos.values());
    }

    public Optional<Monumento> editMonument(Long id, Monumento newValue) {
        return Optional.ofNullable(listaMonumentos.computeIfPresent(id, (k, v) -> {
            v.setLatitud(newValue.getLatitud());
            v.setLongitud(newValue.getLongitud());
            v.setNombrePais(newValue.getNombrePais());
            v.setDescripcion(newValue.getDescripcion());
            v.setURLimagen(newValue.getURLimagen());
            v.setCodPais(newValue.getCodPais());
            v.setNombreMonumento(newValue.getNombreMonumento());
            v.setNombreCiudad(newValue.getNombreCiudad());

            return v;
        }));
    }

    public void deleteMonument(Long id) {
        listaMonumentos.remove(id);
    }

}
