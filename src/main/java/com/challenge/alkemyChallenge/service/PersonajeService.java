package com.challenge.alkemyChallenge.service;


import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.beans.Personaje;
import com.challenge.alkemyChallenge.repository.PeliculaRepository;
import com.challenge.alkemyChallenge.repository.PersonajeRepository;
import com.challenge.alkemyChallenge.response.CustomResponseDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonajeService {


    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;

    private static final Logger LOGGER = Logger.getLogger("PersonajeService");


    public ResponseEntity updatePersonaje(Personaje personaje) {

        ResponseEntity response = null;
        Personaje personaje1 = personajeRepository.findById(personaje.getId());

        if (personajeRepository.findById(personaje.getId()) != null) {
            personaje1.setId(personaje.getId());
            personaje1.setImagen(personaje.getImagen());
            personaje1.setNombre(personaje.getNombre());
            personaje1.setEdad(personaje.getEdad());
            personaje1.setPeso(personaje.getPeso());
            personaje1.setHistoria(personaje.getHistoria());
            response = ResponseEntity.ok(personajeRepository.save(personaje1));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


    public CustomResponseDelete deletePersonajeById(int id) {
        CustomResponseDelete response = null;
        if(personajeRepository.findById(id)==null){
            response = new CustomResponseDelete("Personaje with ID " + id + " not found",  new ResponseEntity(HttpStatus.NOT_FOUND)) ;
        }else{
            personajeRepository.deleteById(id);
            response = new CustomResponseDelete("Personaje with ID " + id + " deleted successfully", new ResponseEntity(HttpStatus.OK));
        }
        return response;
    }



    public ResponseEntity<Personaje> getPersonajeById(int id) {

        ResponseEntity response = null;
        Personaje personaje = personajeRepository.findById(id);
        List<Pelicula> peliculas = peliculaRepository.findPeliculasPersonajes(id);
        LOGGER.info("INGRESA A GET PACIENTE");
        personaje.setPeliculas(peliculas);
        return ResponseEntity.ok(personaje);


    }

}
