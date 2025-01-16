package com.example.ejercicio02_modeladoDeDatos.apartado2.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    private int orden;

    private String titulo;

    private String descripcion;

    private String url;

    @ManyToOne
    @JoinColumn(name = "curso_id",
        foreignKey = @ForeignKey(name = "fk_curso_video")
    )
    private CursoOnline cursoOnline;

    //EQUALS Y HASHCODE

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Video video = (Video) o;
        return getId() != null && Objects.equals(getId(), video.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
