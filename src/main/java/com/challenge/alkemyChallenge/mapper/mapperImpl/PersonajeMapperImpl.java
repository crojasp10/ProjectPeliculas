package com.challenge.alkemyChallenge.mapper.mapperImpl;

import com.challenge.alkemyChallenge.beans.Personaje;
import com.challenge.alkemyChallenge.dto.PersonajeDto;
import com.challenge.alkemyChallenge.mapper.PersonajeMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PersonajeMapperImpl implements PersonajeMapper {
    @Override
    public PersonajeDto personajeToPersonajeDto(Personaje personaje) {
        if (personaje == null) {
            return null;
        }
        PersonajeDto personajeDto = new PersonajeDto();
        personajeDto.setPeso(personaje.getPeso());
        personajeDto.setEdad(personaje.getEdad());
        personajeDto.setImagen(personaje.getImagen());
        personajeDto.setNombre(personaje.getName());
        personajeDto.setHistoria(personaje.getHistoria());

        return personajeDto;

    }

    @Override
    public PersonajeDto toDto(Personaje personaje) {
        return null;
    }

    @Override
    public List<PersonajeDto> toDtoList(List<Personaje> personajes) {

        List<PersonajeDto> personajeDtoList = personajes.stream().map(personaje -> {
            PersonajeDto personajeDto = new PersonajeDto();
            personajeDto.setPeso(personaje.getPeso());
            personajeDto.setEdad(personaje.getEdad());
            personajeDto.setImagen(personaje.getImagen());
            personajeDto.setNombre(personaje.getName());
            personajeDto.setHistoria(personaje.getHistoria());
            return personajeDto;
        }).collect(Collectors.toList());

        return personajeDtoList;

    }
}
