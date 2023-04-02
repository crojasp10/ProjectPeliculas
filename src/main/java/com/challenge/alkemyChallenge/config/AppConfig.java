package com.challenge.alkemyChallenge.config;

import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.beans.Personaje;
import com.challenge.alkemyChallenge.dto.PeliculaDto;
import com.challenge.alkemyChallenge.dto.PersonajeDto;
import com.challenge.alkemyChallenge.mapper.GeneroMapper;
import com.challenge.alkemyChallenge.mapper.PeliculaMapper;
import com.challenge.alkemyChallenge.mapper.PersonajeMapper;
import com.challenge.alkemyChallenge.mapper.mapperImpl.GeneroMapperImpl;
import com.challenge.alkemyChallenge.mapper.mapperImpl.PeliculaMapperImpl;
import com.challenge.alkemyChallenge.mapper.mapperImpl.PersonajeMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public PersonajeMapper personajeMapper() {
        return new PersonajeMapperImpl();
    }

    @Bean
    public PeliculaMapperImpl peliculaMapper() {
        return new PeliculaMapperImpl();
    }

    @Bean
    public GeneroMapperImpl generoMapper() {
        return new GeneroMapperImpl();
    }
}
