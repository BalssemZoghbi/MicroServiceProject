package com.example.chambre.dto;

import com.example.chambre.entity.TypeChambre;
import lombok.*;

@Builder
public record ChambreDto(
        Long idChambre,
        long numeroChambre,
        TypeChambre typeC,
        String hotelId,
        HotelDto hotelDto
) {

}
