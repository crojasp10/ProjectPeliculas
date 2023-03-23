package com.challenge.alkemyChallenge.repository;


import com.challenge.alkemyChallenge.beans.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeliculaRepository extends JpaRepository <Pelicula, Integer> {


    Pelicula save(Pelicula pelicula);

    Pelicula findById(int id);

    //Aquí se usa la query para traer los campos de las películas de un respectivo personaje.
    @Query(value = "SELECT pelicula.id,pelicula.calificacion,pelicula.fecha_de_creacion,pelicula.imagen,pelicula.titulo,pelicula.genero_id from Personaje INNER JOIN personaje_pelicula on personaje_pelicula.personaje_id = personaje.id INNER JOIN Pelicula on personaje_pelicula.pelicula_id = pelicula.id where personaje.id = :id",
            nativeQuery = true)
    List<Pelicula> findPeliculasPersonajes(@Param("id") Integer id);
}
