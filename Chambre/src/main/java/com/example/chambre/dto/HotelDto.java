package com.example.chambre.dto;

import lombok.Builder;

@Builder
public record HotelDto(
        String id,
        String name,
        String address
) {
}
