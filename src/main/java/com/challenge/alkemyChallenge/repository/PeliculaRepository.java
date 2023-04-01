package com.challenge.alkemyChallenge.repository;


import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.beans.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeliculaRepository extends JpaRepository <Pelicula, Integer> {


    Pelicula save(Pelicula pelicula);

    Pelicula findById(int id);

    //Aquí se usa la query para traer los campos de las películas de un respectivo personaje.
    @Query(value = "SELECT pelicula.id,pelicula.calificacion,pelicula.fecha_de_creacion,pelicula.imagen,pelicula.titulo,pelicula.genero_id, pelicula_personaje.pelicula_id, pelicula_personaje.personaje_id from Pelicula INNER JOIN pelicula_personaje on pelicula_personaje.personaje_id = pelicula_id where pelicula_personaje.personaje_id = :id",
            nativeQuery = true)
    List<Pelicula> findPeliculaPersonajes(@Param("id") Integer id);

    List<Pelicula> findAll();

}
