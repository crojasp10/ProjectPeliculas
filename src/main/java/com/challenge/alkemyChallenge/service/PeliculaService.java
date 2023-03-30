package com.challenge.alkemyChallenge.service;

import com.challenge.alkemyChallenge.beans.Genero;
import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.beans.Personaje;
import com.challenge.alkemyChallenge.repository.GeneroRepository;
import com.challenge.alkemyChallenge.repository.PeliculaRepository;
import com.challenge.alkemyChallenge.repository.PersonajeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PeliculaService {


    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

    public ResponseEntity savePelicula(Pelicula pelicula) {

        ResponseEntity response = null;

        Pelicula pelicula1 = pelicula;

        List <Personaje> listaPersonajes =
                pelicula.getPersonajes().stream().map(personaje -> {
                    Integer id = personaje.getId();
                    return personajeRepository.findById(id);
                }).collect(Collectors.toList()).stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        log.info("Los personajes SON: "+ listaPersonajes);
        Genero genero1 = generoRepository.findById(pelicula.getGenero().getId());

        if (generoRepository.findById(pelicula.getGenero().getId()) != null) {
            log.info("el genero es: " + generoRepository.findById(pelicula.getGenero().getId()));
            pelicula1.setId(pelicula.getId());
            pelicula1.setImagen(pelicula.getImagen());
            pelicula1.setTitulo(pelicula.getTitulo());
            pelicula1.setFechaDeCreacion(pelicula.getFechaDeCreacion());
            pelicula1.setCalificacion(pelicula.getCalificacion());
            pelicula1.setGenero(genero1);
            pelicula1.setPersonajes(listaPersonajes);
            response = ResponseEntity.ok(peliculaRepository.save(pelicula1));
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;

    }

    public ResponseEntity getPeliculaById(int id) {
        return ResponseEntity.ok(peliculaRepository.findById(id));
    }



}
