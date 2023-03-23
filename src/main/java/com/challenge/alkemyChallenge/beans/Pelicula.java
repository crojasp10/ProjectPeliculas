package com.challenge.alkemyChallenge.beans;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

}
