package com.challenge.alkemyChallenge.config;

import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.beans.Personaje;
import com.challenge.alkemyChallenge.dto.PeliculaDto;
import com.challenge.alkemyChallenge.dto.PersonajeDto;
import com.challenge.alkemyChallenge.mapper.PeliculaMapper;
import com.challenge.alkemyChallenge.mapper.PersonajeMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {


        @Bean
        public PersonajeMapper personajeMapper() {
            return new PersonajeMapper() {
                @Override
                public PersonajeDto personajeToPersonajeDto(Personaje personaje) {
                    return null;
                }
            };

    }
    @Bean
    public PeliculaMapper peliculaMapperMapper() {
        return new PeliculaMapper() {
            @Override
            public PeliculaDto peliculaToPeliculaDto(Pelicula pelicula) {
                return null;
            }

            @Override
            public Pelicula peliculaDtoToPelicula(PeliculaDto peliculaDto) {
                return null;
            }

            @Override
            public List<PeliculaDto> peliculasToPeliculasDto(List<Pelicula> peliculas) {
                return null;
            }

            @Override
            public List<Pelicula> peliculasDtoToPeliculas(List<PeliculaDto> peliculasDto) {
                return null;
            }
        };

    }


}
