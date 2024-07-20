package com.example.hotelms.controllers;

import com.example.hotelms.dto.HotelRequest;
import com.example.hotelms.dto.HotelDto;
import com.example.hotelms.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveHotel(@RequestBody HotelRequest hotelRequest){
     hotelService.saveHotel(hotelRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HotelDto> getAllHotels(){
      return  hotelService.getAllHotels();
    }
}
