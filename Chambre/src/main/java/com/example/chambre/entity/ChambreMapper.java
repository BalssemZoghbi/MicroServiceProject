package com.example.chambre.entity;

import com.example.chambre.dto.ChambreDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChambreMapper {
    ChambreMapper INSTANCE = Mappers.getMapper(ChambreMapper.class);
    @Mapping(source = "id", target = "idChambre")
    ChambreDto toDto(Chambre chambre);
    @Mapping(source = "idChambre", target = "id")
    Chambre toEntity(ChambreDto chambreDto);

}
