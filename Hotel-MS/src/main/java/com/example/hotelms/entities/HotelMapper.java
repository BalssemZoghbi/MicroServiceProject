package com.example.hotelms.entities;

import com.example.hotelms.dto.HotelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);
    @Mapping(target = "id", source = "hotelId")
    HotelDto toDto(Hotel hotel);
    @Mapping(target = "hotelId", source = "id")
    Hotel toEntity(HotelDto hotelDto);
}