package com.challenge.alkemyChallenge.controller;



import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.repository.PeliculaRepository;
import com.challenge.alkemyChallenge.response.CustomResponse;
import com.challenge.alkemyChallenge.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping("/newPelicula")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity savePelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.savePelicula(pelicula);
    }

    @GetMapping("/getPelicula/{id}")
    public ResponseEntity getPelicula(@PathVariable (value = "id") int id) {
        return ResponseEntity.ok().header("El header es").body(peliculaService.getPeliculaById(id));
    }
    @GetMapping("/getPeliculas")
    public ResponseEntity getPeliculas() {
        return ResponseEntity.ok().header("El header es").body(peliculaService.getPeliculas());
    }
}
