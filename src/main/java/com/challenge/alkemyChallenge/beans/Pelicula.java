package com.challenge.alkemyChallenge.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pelicula")
public class Pelicula {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="imagen")
    private String imagen;
    @Column(name="titulo")
    private String titulo;
    @Column(name="fechaDeCreacion")
    private String fechaDeCreacion;
    @Column(name="calificacion")
    private String calificacion;

    @ManyToOne(  fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "genero_id",referencedColumnName = "id")
    private Genero genero;

    @ManyToMany
    @JoinTable(name = "pelicula_personaje", joinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id", referencedColumnName = "id"))
    private List<Personaje> personajes;



    public boolean equals(Pelicula o) {
        o.setId(0);
        o.getPersonajes().forEach(personaje -> personaje.setId(0));
        o.genero.setId(0);
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(titulo, pelicula.titulo);
    }



}
