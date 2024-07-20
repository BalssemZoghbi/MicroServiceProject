package com.example.hotelms.dto;

import com.example.hotelms.entities.Hotel;
import com.example.hotelms.entities.HotelMapper;
import lombok.Builder;

@Builder
public record HotelDto(
        String id,
        String name,
        String address
) {

    public static HotelDto mapFromEntity(Hotel hotel) {
        return HotelMapper.INSTANCE.toDto(hotel);
    }
    public static Hotel mapToEntity(HotelDto hotelDto) {
        return HotelMapper.INSTANCE.toEntity(hotelDto);
    }
}
