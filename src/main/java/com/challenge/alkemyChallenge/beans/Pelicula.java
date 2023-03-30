package com.challenge.alkemyChallenge.beans;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="pelicula_id", referencedColumnName="id")
    private List<Personaje> personajes;



}
