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

        Pelicula existingPelicula = peliculaRepository.findByTitulo(pelicula.getTitulo());
        if (existingPelicula!=null){
            response = (existingPelicula.equals(pelicula))?ResponseEntity.status(HttpStatus.CONFLICT).body("La pelicula ya existe en la base de datos"):null;
        }
        else{

            Pelicula pelicula1 = pelicula;

            List <Personaje> listaPersonajes =
                    pelicula.getPersonajes().stream()
                            .filter(personaje -> personaje != null )
                            .peek(personaje -> {
                                        Personaje existingPersonaje = personajeRepository.findByName(personaje.getName());
                                        if(existingPersonaje != null) {
                                            log.info("Personaje already exists");
                                            personaje.setId(existingPersonaje.getId());
                                        } else {
                                            personajeRepository.save(personaje);
                                        }
                                    }
                            )
                            .collect(Collectors.toList());

            log.info("Los personajes SON: "+ listaPersonajes);
            //Genero genero1 = generoRepository.findById(pelicula.getGenero().getId());
            Genero genero1 = pelicula.getGenero();

            if (genero1!= null) {
                generoRepository.save(genero1);
                log.info("el genero es: " + genero1);
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

        }
        return response;

    }



    public ResponseEntity getPeliculaById(int id) {
        return ResponseEntity.ok(peliculaRepository.findById(id));
    }


    public ResponseEntity getPeliculas() {
        return ResponseEntity.ok(peliculaRepository.findAll());
    }



}
