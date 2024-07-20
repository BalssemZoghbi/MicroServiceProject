package com.example.hotelms.services;

import com.example.hotelms.dto.HotelRequest;
import com.example.hotelms.dto.HotelDto;

import java.util.List;

public interface IHotelService {
    List<HotelDto> getAllHotels();
    HotelDto getHotelById(String id);
    HotelDto saveHotel(HotelDto hotelDto);
    //void updateHotel(String id, HotelRequest hotelRequest);
    void deleteHotel(String id);

}
