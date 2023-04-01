package com.challenge.alkemyChallenge.controller;


import com.challenge.alkemyChallenge.beans.Personaje;
import com.challenge.alkemyChallenge.repository.PersonajeRepository;
import com.challenge.alkemyChallenge.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin ( origins = "*" , methods= { RequestMethod. GET ,RequestMethod. POST,RequestMethod. PUT })
@RequestMapping("/personaje")
public class PersonajeController {

    private static final Logger LOGGER = Logger.getLogger("TestLog");
    private static Personaje personaje;


    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PersonajeService personajeService;

    @PostMapping("/newPersonaje")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Personaje> insertarPersonaje(@RequestBody Personaje personaje) {
        LOGGER.info("Se crea un nuevo personaje");
        return ResponseEntity.ok(personajeRepository.save(personaje));

    }

    @GetMapping("/getPersonajes")
    public ResponseEntity<List<Personaje>> listarPersonajes() {
        return ResponseEntity.ok(personajeRepository.findAll());
    }

    @GetMapping("/getPersonaje/{id}")
    public ResponseEntity getPersonajeById(@PathVariable (value = "id") int id) {
        return ResponseEntity.ok(personajeService.findPersonajeById(id));
    }

    @PutMapping("/updatePersonaje")
    public ResponseEntity updatePersonaje( @RequestBody Personaje personaje){
        LOGGER.info("Update personaje");
        return ResponseEntity.ok(personajeService.updatePersonaje(personaje));
    }

    @DeleteMapping("/deletePersonaje/{id}")
    public ResponseEntity deletePersonajeById(@PathVariable (value = "id") int id) {
        System.out.println("Se elimina el Personaje");
        return ResponseEntity.ok(personajeService.deletePersonajeById(id));
    }
//Aquí le paso el id a la url de la siguiente forma  http://localhost:8080/personaje?id=3 y me envía el personaje con id = 3
   /* @GetMapping
    public ResponseEntity listarPersonajesPelicula(@RequestParam (value = "id") int id) {
        return ResponseEntity.ok(personajeService.getPersonajeById(id));

    }*/



}
