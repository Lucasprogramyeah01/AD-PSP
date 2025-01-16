package com.example.ejercicio02_modeladoDeDatos.apartado2.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double puntuacion;

    //ASOCIACIÓN CON PROFESOR (MC - 1P)

    @ManyToOne
    @JoinColumn(name = "profesor_id",
        foreignKey = @ForeignKey(name = "fk_curso_profesor")
    )
    private Profesor profesor;

    //ASOCIACIÓN CON VIDEO (1C - MV)

    @OneToMany(mappedBy = "cursoOnline",
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @Builder.Default
    @ToString.Exclude
    private Set<Video> listaVideos = new HashSet<>();

    //Métodos Helper (De Vídeo)

        public void addVideo (Video v){
            v.setCursoOnline(this);
            this.listaVideos.add(v);
        }

        public void removeVideo (Video v){
            this.listaVideos.remove(v);
            v.setCursoOnline(null);
        }

    //EQUALS Y HASHCODE

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CursoOnline that = (CursoOnline) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
