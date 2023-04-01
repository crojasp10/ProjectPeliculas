package com.challenge.alkemyChallenge.mapper;

import com.challenge.alkemyChallenge.beans.Personaje;
import com.challenge.alkemyChallenge.dto.PersonajeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PersonajeMapper {

    PersonajeMapper INSTANCIA= Mappers.getMapper(PersonajeMapper.class);

    @Mapping(source = "peliculas", target = "peliculasDto")
    PersonajeDto personajeToPersonajeDto(Personaje personaje);






}
