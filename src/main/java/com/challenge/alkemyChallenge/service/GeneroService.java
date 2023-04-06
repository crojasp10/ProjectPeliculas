package com.challenge.alkemyChallenge.service;

import com.challenge.alkemyChallenge.beans.Genero;
import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    @Autowired
    GeneroRepository generoRepository;

    public ResponseEntity saveGenero(Genero genero){
        ResponseEntity response = null;

        Genero existingGenero = generoRepository.findByNombre(genero.getNombre());
        if (existingGenero!=null){
            response = (existingGenero.equals(genero))?ResponseEntity.status(HttpStatus.CONFLICT).body("El genero ya existe en la base de datos"):null;
        }
        else{
            response = ResponseEntity.ok(generoRepository.save(genero));
        }
        return response;
    }


}
