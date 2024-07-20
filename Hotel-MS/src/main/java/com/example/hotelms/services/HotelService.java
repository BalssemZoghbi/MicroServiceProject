package com.example.hotelms.services;

import com.example.hotelms.dto.HotelDto;
import com.example.hotelms.entities.Hotel;
import com.example.hotelms.repository.HotelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class HotelService implements IHotelService {
    private HotelRepository hotelRepository;
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "hotel-topic";

    public List<HotelDto> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(HotelDto::mapFromEntity)
                .collect(Collectors.toList());
    }

    public HotelDto getHotelById(String id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        return HotelDto.mapFromEntity(hotel);
    }

    public HotelDto saveHotel(HotelDto hotelDto) {
        Hotel hotel = HotelDto.mapToEntity(hotelDto);
        hotel = hotelRepository.save(hotel);
        return HotelDto.mapFromEntity(hotel);
    }

    public void deleteHotel(String id) {
        hotelRepository.deleteById(id);
    }


}

