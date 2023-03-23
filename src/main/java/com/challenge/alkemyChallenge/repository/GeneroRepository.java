package com.challenge.alkemyChallenge.repository;

import com.challenge.alkemyChallenge.beans.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository <Genero, Integer> {


    Genero findById(int id);


}
