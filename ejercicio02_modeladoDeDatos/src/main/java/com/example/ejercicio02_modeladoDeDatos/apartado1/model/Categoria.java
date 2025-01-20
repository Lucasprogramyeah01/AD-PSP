package com.example.ejercicio02_modeladoDeDatos.apartado1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    //ASOCIACIÓN CON PRODUCTO (1C - MP)

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private Set<Producto> listaProductos = new HashSet<>();

    //ASOCIACIÓN CON CATEGORÍA (1C - MC)

    @ManyToOne
    @JoinColumn(name = "categoria_relacion_id",
            foreignKey = @ForeignKey(name = "fk_categoria_padre_categoria")
    )
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Categoria> listaCategoriasHijas = new ArrayList<>();

    //Métodos helper (Con Producto)

        public void addProducto (Producto p){
            p.setCategoria(this);
            this.listaProductos.add(p);
        }

        public void removeProducto (Producto p){
            this.listaProductos.remove(p);
            p.setCategoria(null);
        }

    //Métodos helper (Con Categoria)

        public void addCategoria (Categoria c){
            c.setCategoriaPadre(this);
            this.listaCategoriasHijas.add(c);
        }

        public void removeCategoria (Categoria c){
            this.listaCategoriasHijas.remove(c);
            c.setCategoriaPadre(null);
        }

    //EQUALS Y HASHCODE

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Categoria categoria = (Categoria) o;
        return getId() != null && Objects.equals(getId(), categoria.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
