package com.challenge.alkemyChallenge.controller;


import com.challenge.alkemyChallenge.beans.Genero;
import com.challenge.alkemyChallenge.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin( origins = "*" , methods= { RequestMethod. GET ,RequestMethod. POST,RequestMethod. PUT })
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    GeneroRepository generoRepository;

    @PostMapping("/newGenero")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Genero> insertarGenero(@RequestBody Genero genero) {

        return ResponseEntity.ok(generoRepository.save(genero));

    }




}
