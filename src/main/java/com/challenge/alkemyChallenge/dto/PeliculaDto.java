package com.challenge.alkemyChallenge.dto;

import com.challenge.alkemyChallenge.beans.Genero;
import com.challenge.alkemyChallenge.beans.Personaje;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.List;

@Data
public class PeliculaDto {

    private String imagen;

    private String titulo;

    private String fechaDeCreacion;

    private String calificacion;

    private GeneroDto genero;

    @JsonIgnore
    private List<Personaje> personajes;



}
