package com.challenge.alkemyChallenge.beans;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="imagen")
    private String imagen;

    public boolean equals(Genero o) {
        o.setId(0);
        if (this == o) return true;
        if (!(o instanceof Genero)) return false;
        Genero genero = (Genero) o;
        return Objects.equals(nombre, genero.getNombre());
    }


}
