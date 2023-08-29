package com.example.must.myrmidons.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.must.myrmidons.domain.Membre;
import com.example.must.myrmidons.dto.MembreDto;

@Mapper
public interface MembreMapper {

    MembreMapper INSTANCE = Mappers.getMapper(MembreMapper.class);

    MembreDto membreToMembreDto(Membre membre);

    Membre membreDtoToMembre(MembreDto membreDto);

    List<MembreDto> map(List<Membre> list);
}