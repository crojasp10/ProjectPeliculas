package com.challenge.alkemyChallenge.repository;


import com.challenge.alkemyChallenge.beans.Pelicula;
import com.challenge.alkemyChallenge.beans.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonajeRepository extends JpaRepository <Personaje, Integer> {

    Personaje findById(int id);

    /*@Query(value = "SELECT personaje.id, personaje.nombre,personaje.imagen,personaje.edad,personaje.peso, personaje.historia, pelicula.id,pelicula.calificacion,pelicula.fecha_de_creacion,pelicula.imagen,pelicula.titulo,pelicula.genero_id from Personaje INNER JOIN personaje_pelicula on personaje_pelicula.personaje_id = personaje.id INNER JOIN Pelicula on personaje_pelicula.pelicula_id = pelicula.id where personaje.id = :id",
            nativeQuery = true)
    List<Personaje> findPersonajesPelicula(@Param("id") Integer id);*/

    List<Personaje> findByIdIn(List<Integer> ids);







}
