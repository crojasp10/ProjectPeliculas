package com.challenge.alkemyChallenge.mapper;

import com.challenge.alkemyChallenge.beans.Genero;
import com.challenge.alkemyChallenge.dto.GeneroDto;
import org.mapstruct.factory.Mappers;

public interface GeneroMapper {

    PeliculaMapper INSTANCIA = Mappers.getMapper(PeliculaMapper.class);

    GeneroDto generoToGeneroDto(Genero genero);


}
