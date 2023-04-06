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

    @GetMapping("/getPelicula/{titulo}")
    public ResponseEntity getPelicula(@PathVariable (value = "titulo") String titulo) {
        return ResponseEntity.ok().header("El header es").body(peliculaService.getPeliculaByTitulo(titulo));
    }
    @GetMapping("/getPeliculas")
    public ResponseEntity getPeliculas() {
        return ResponseEntity.ok().header("El header es").body(peliculaService.getPeliculas());
    }

    @DeleteMapping("/deletePelicula/{id}")
    public ResponseEntity deletePeliculaById(@PathVariable (value = "id") int id) {
        System.out.println("Se elimina el Pelicula");
        return peliculaService.deletePeliculaById(id);
    }

    @PutMapping("/updatePelicula")
    public ResponseEntity updatePelicula( @RequestBody Pelicula pelicula){
        System.out.println("Se recibe el personaje"+pelicula);
        return peliculaService.updatePelicula(pelicula);
    }

}
