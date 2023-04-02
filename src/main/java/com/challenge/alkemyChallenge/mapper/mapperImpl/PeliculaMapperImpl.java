package com.challenge.alkemyChallenge.mapper.mapperImpl;

import com.challenge.alkemyChallenge.beans.Genero;
import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.dto.GeneroDto;
import com.challenge.alkemyChallenge.dto.PeliculaDto;
import com.challenge.alkemyChallenge.dto.PersonajeDto;
import com.challenge.alkemyChallenge.mapper.GeneroMapper;
import com.challenge.alkemyChallenge.mapper.PeliculaMapper;
import com.challenge.alkemyChallenge.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PeliculaMapperImpl implements PeliculaMapper {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private GeneroMapperImpl generoMapperImpl;


    @Override
    public PeliculaDto peliculaToPeliculaDto(Pelicula pelicula) {
        if (pelicula == null) {
            return null;
        }
        PeliculaDto peliculaDto = new PeliculaDto();
        Genero genero = generoRepository.findById(pelicula.getGenero().getId());
        GeneroDto generoDto = generoMapperImpl.generoToGeneroDto(genero);
        peliculaDto.setImagen(pelicula.getImagen());
        peliculaDto.setCalificacion(pelicula.getCalificacion());
        peliculaDto.setTitulo(pelicula.getTitulo());
        peliculaDto.setFechaDeCreacion(pelicula.getFechaDeCreacion());
        peliculaDto.setGenero(generoDto);

        return peliculaDto;

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
}
