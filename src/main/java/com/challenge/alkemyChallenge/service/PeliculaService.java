package com.challenge.alkemyChallenge.service;

import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {


    @Autowired
    private PeliculaRepository peliculaRepository;


    public ResponseEntity savePelicula(Pelicula pelicula) {
        return ResponseEntity.ok(peliculaRepository.save(pelicula));
    }

    public ResponseEntity getPeliculaById(int id) {
        return ResponseEntity.ok(peliculaRepository.findById(id));
    }



}
