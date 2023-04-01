package com.challenge.alkemyChallenge.dto;


import com.challenge.alkemyChallenge.beans.Pelicula;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PersonajeDto {

    private String imagen;

    private String nombre;

    private String edad;

    private String peso;

    private String historia;

    private List<PeliculaDto> peliculasDto;



}
