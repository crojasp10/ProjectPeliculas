package com.challenge.alkemyChallenge.beans;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "imagen")
    private String imagen;
    @Column(name = "nombre")
    private String name;
    @Column(name = "edad")
    private String edad;
    @Column(name = "peso")
    private String peso;
    @Column(name = "historia")
    private String historia;

    @ManyToMany(mappedBy = "personajes")
    private List<Pelicula> peliculas;

    public boolean equals(Personaje o) {
        o.setId(0);
        o.getPeliculas().forEach(pelicula ->{
            pelicula.setId(0);
            pelicula.getGenero().setId(0);
        } );

        if (this == o) return true;
        if (!(o instanceof Personaje)) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(name, personaje.name);
    }


}
