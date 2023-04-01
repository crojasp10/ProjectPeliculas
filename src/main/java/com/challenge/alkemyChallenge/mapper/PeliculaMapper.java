package com.challenge.alkemyChallenge.mapper;

import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.dto.PeliculaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

    @Mapper
    @Component
    public interface PeliculaMapper {

        PeliculaMapper INSTANCIA = Mappers.getMapper(PeliculaMapper.class);

        PeliculaDto peliculaToPeliculaDto(Pelicula pelicula);

        Pelicula peliculaDtoToPelicula(PeliculaDto peliculaDto);

        List<PeliculaDto> peliculasToPeliculasDto(List<Pelicula> peliculas);

        List<Pelicula> peliculasDtoToPeliculas(List<PeliculaDto> peliculasDto);
    }

