package com.challenge.alkemyChallenge.mapper.mapperImpl;

import com.challenge.alkemyChallenge.beans.Genero;
import com.challenge.alkemyChallenge.dto.GeneroDto;
import com.challenge.alkemyChallenge.mapper.GeneroMapper;

public class GeneroMapperImpl implements GeneroMapper {
    @Override
    public GeneroDto generoToGeneroDto(Genero genero) {
        GeneroDto generoDto = new GeneroDto();
        generoDto.setNombre(genero.getNombre());
        generoDto.setImagen(genero.getImagen());
        return generoDto;
    }
}
