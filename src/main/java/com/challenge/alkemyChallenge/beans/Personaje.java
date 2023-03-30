package com.challenge.alkemyChallenge.beans;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private String nombre;
    @Column(name = "edad")
    private String edad;
    @Column(name = "peso")
    private String peso;
    @Column(name = "historia")
    private String historia;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="personaje_id", referencedColumnName="id")
    private List<Pelicula> peliculas;


}
