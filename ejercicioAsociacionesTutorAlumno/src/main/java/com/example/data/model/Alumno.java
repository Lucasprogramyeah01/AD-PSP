package com.example.data.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Alumno {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private String apellidos;

    private String email;

    private String direccion;

    //ASOCIACIÓN CON ALUMNO (M-1)

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_alumno_tutor"))
    private Tutor tutor;

    //EQUALS Y HASCODE

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Alumno alumno = (Alumno) o;
        return getId() != null && Objects.equals(getId(), alumno.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    //MÉTODOS HELPER


}
