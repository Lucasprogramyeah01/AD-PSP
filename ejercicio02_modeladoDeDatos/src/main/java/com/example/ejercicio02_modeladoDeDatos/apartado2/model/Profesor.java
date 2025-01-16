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
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    private double puntuacion;

    //ASOCIACIÓN CON CURSO ONLINE (1P - MC)

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private Set<CursoOnline> listaCursosOnline = new HashSet<>();

    //Métodos Helper

        public void addCursoOnline (CursoOnline c){
            c.setProfesor(this);
            this.listaCursosOnline.add(c);
        }

        public void removeCursoOnline (CursoOnline c){
            this.listaCursosOnline.remove(c);
            c.setProfesor(null);
        }

    //EQUALS Y HASHCODE

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Profesor profesor = (Profesor) o;
        return getId() != null && Objects.equals(getId(), profesor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
