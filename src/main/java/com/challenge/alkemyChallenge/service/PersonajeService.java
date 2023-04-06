package com.challenge.alkemyChallenge.service;


import com.challenge.alkemyChallenge.dto.PeliculaDto;
import com.challenge.alkemyChallenge.dto.PersonajeDto;
import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.beans.Personaje;

import com.challenge.alkemyChallenge.mapper.PersonajeMapper;
import com.challenge.alkemyChallenge.mapper.mapperImpl.PeliculaMapperImpl;
import com.challenge.alkemyChallenge.mapper.mapperImpl.PersonajeMapperImpl;
import com.challenge.alkemyChallenge.repository.GeneroRepository;
import com.challenge.alkemyChallenge.repository.PeliculaRepository;
import com.challenge.alkemyChallenge.repository.PersonajeRepository;
import com.challenge.alkemyChallenge.response.CustomResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PersonajeService {


    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    private PersonajeMapperImpl personajeMapperImpl;

    @Autowired
    private PeliculaMapperImpl peliculaMapperImpl;

    private static final Logger LOGGER = Logger.getLogger("PersonajeService");


    public ResponseEntity updatePersonaje(Personaje personaje) {

        ResponseEntity response = null;
        Personaje personaje1 = personajeRepository.findById(personaje.getId());

        if (personajeRepository.findById(personaje.getId()) != null) {
            personaje1.setId(personaje.getId());
            personaje1.setImagen(personaje.getImagen());
            personaje1.setName(personaje.getName());
            personaje1.setEdad(personaje.getEdad());
            personaje1.setPeso(personaje.getPeso());
            personaje1.setHistoria(personaje.getHistoria());
            response = ResponseEntity.ok(personajeRepository.save(personaje1));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


    public CustomResponse deletePersonajeById(int id) {
        CustomResponse response = null;
        if(personajeRepository.findById(id)==null){
            response = new CustomResponse("Personaje with ID " + id + " not found",  new ResponseEntity(HttpStatus.NOT_FOUND)) ;
        }else{
            personajeRepository.deleteById(id);
            response = new CustomResponse("Personaje with ID " + id + " deleted successfully", new ResponseEntity(HttpStatus.OK));
        }
        return response;
    }

    public ResponseEntity<PersonajeDto> findPersonajeByName(String name) {
        Personaje personaje = personajeRepository.findByName(name);

        PersonajeDto personajeDto = personajeMapperImpl.personajeToPersonajeDto(personaje);
        List<Pelicula> peliculas= peliculaRepository.findPeliculaPersonajes(personaje.getName());

        List<PeliculaDto> peliculasDto = peliculas.stream().map(pelicula->{
            PeliculaDto peliculaDto = peliculaMapperImpl.peliculaToPeliculaDto(pelicula);
            return peliculaDto;
        }).collect(Collectors.toList());
        personajeDto.setPeliculas(peliculasDto);
        return ResponseEntity.ok(personajeDto);
    }

    public  List<PersonajeDto> findAll() {
        List<PersonajeDto> personajesDto = personajeMapperImpl.toDtoList(personajeRepository.findAll());

        List<PersonajeDto> listaPersonajes = personajesDto.stream().map(personajeDto -> {
            PersonajeDto personajeDtoResult = personajeDto;
            String nombre = personajeDto.getNombre();
            List<Pelicula> peliculas= peliculaRepository.findPeliculaPersonajes(nombre);
            List<PeliculaDto> peliculasDto = peliculas.stream().map(pelicula->{
                PeliculaDto peliculaDto = peliculaMapperImpl.peliculaToPeliculaDto(pelicula);
                        return peliculaDto;
            }).collect(Collectors.toList());
            personajeDtoResult.setPeliculas(peliculasDto);
            return personajeDtoResult;
        }).collect(Collectors.toList());


        return (listaPersonajes);
    }


}
