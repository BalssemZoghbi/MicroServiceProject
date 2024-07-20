package com.example.hotelms.controllers;

import com.example.hotelms.dto.HotelRequest;
import com.example.hotelms.dto.HotelDto;
import com.example.hotelms.services.HotelService;
import com.example.hotelms.services.IHotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@Slf4j
@RequiredArgsConstructor
@RefreshScope
public class HotelController {
    private final IHotelService hotelService;

    @GetMapping
    public List<HotelDto> getAllHotel() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public HotelDto getHotelById(@PathVariable String id) {
        return hotelService.getHotelById(id);
    }

    @PostMapping
    public HotelDto saveHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.saveHotel(hotelDto);
    }

    @PutMapping("/{id}")
    public HotelDto updateHotel(@PathVariable String id, @RequestBody HotelDto hotelDto) {return hotelService.saveHotel(hotelDto);}

    @DeleteMapping("/{id}")
    public void deleteEdt(@PathVariable String id) {
        hotelService.deleteHotel(id);
    }

}
