package com.example.ejemploSecurity2.user.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="user_entity")
public class User implements UserDetails {

    // Usamos UUID como ID de los usuarios.
    // Se utiliza la estrategia de generación basada en IP y fecha.

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NaturalId
    @Column(unique = true, updatable = false)
    private String username;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<UserRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    //BAELDUNG 2.2
    @Column(name = "enabled")
    private boolean enabled;

    private

    /*@CreatedDate
    private LocalDateTime createdAt;*/

    /*@Builder.Default
    private LocalDateTime lastPasswordChangeAt = LocalDateTime.now();*/

    /* @ElementCollection
    ----------------------------------------------------------------------------------------------------------------
    La anotación @ElementCollection es una característica útil en JPA para mapear estructuras de datos complejas.
    Nos permite almacenar colecciones de valores como entidades separadas, sin tener que crear una clase de
    entidad adicional. Sus principales ventajas incluyen la simplicidad y una mejor legibilidad del código.

    La anotación @ElementCollection en JPA nos permite almacenar colecciones de tipos wrapper de la biblioteca
    estándar o cadenas u objetos embebibles dentro de una entidad, sin tener que crear entidades separadas
    y definir sus relaciones. Podemos usarla para modelar estructuras de datos complejas de una manera simple
    y confiable. */

    /* @CreatedDate
    ----------------------------------------------------------------------------------------------------------------
    Se utiliza para marcar un campo en la clase de entidad que debe completarse automáticamente con
    la fecha y la hora en que se crea la entidad. */

}
