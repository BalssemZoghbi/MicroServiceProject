package com.example.chambre.services;

import com.example.chambre.dto.ChambreDto;
import com.example.chambre.dto.HotelDto;
import com.example.chambre.entity.Chambre;
import com.example.chambre.entity.ChambreMapper;
import com.example.chambre.entity.HotelClient;
import com.example.chambre.entity.TypeChambre;
import com.example.chambre.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class ChambreServiceImpl implements IChambreService {
    @Autowired
    ChambreRepository chambreRepository;
    private HotelClient hotelClient;
    private ChambreMapper chambreMapper;
    private RestTemplate restTemplate;
    private static final String Hotel_URL = "http://hotel-MS/hotel/";

    public ChambreDto getChambreById(Long id) {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String token = jwt.getTokenValue();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return chambreRepository.findById(id).map(chambre -> {
            ResponseEntity<HotelDto> response = restTemplate.exchange(
                    Hotel_URL + chambre.getHotelId(),
                    HttpMethod.GET,
                    entity,
                    HotelDto.class
            );
            HotelDto hotelDto = response.getBody();
            ChambreDto chambreDto = chambreMapper.toDto(chambre);
            return new ChambreDto(
                    chambreDto.idChambre(),
                    chambreDto.numeroChambre(),
                    chambreDto.typeC(),
                    chambreDto.hotelId()
                    , hotelDto);
        }).orElseThrow(() -> new IllegalArgumentException("Chambre not found"));
    }

    public ChambreDto saveChambre(ChambreDto chambreDto) {
        HotelDto hotelDto = hotelClient.getHotelById(chambreDto.hotelId());
        if (hotelDto != null) {
            Chambre c = chambreMapper.toEntity(chambreDto);
            chambreRepository.save(c);
            return new ChambreDto(
                    chambreDto.idChambre(),
                    chambreDto.numeroChambre(),
                    chambreDto.typeC(),
                    chambreDto.hotelId()
                    , hotelDto);
        } else throw new IllegalArgumentException("Hotel not found");
    }

    public ChambreDto updateChambre(ChambreDto chambreDto) {
        HotelDto hotelDto = hotelClient.getHotelById(chambreDto.hotelId());
        if (hotelDto != null) {
            Chambre c = chambreMapper.toEntity(chambreDto);
            chambreRepository.save(c);
            return new ChambreDto(
                    chambreDto.idChambre(),
                    chambreDto.numeroChambre(),
                    chambreDto.typeC(),
                    chambreDto.hotelId()
                    , hotelDto);
        } else throw new IllegalArgumentException("Hotel not found");
    }

    public List<ChambreDto> AllChambres() {
        return chambreRepository.findAll().stream()
                .map(c -> {
                    ChambreDto chambreDto = chambreMapper.toDto(c);
                    HotelDto hotelDto = hotelClient.getHotelById(chambreDto.hotelId());
                    return new ChambreDto(
                            chambreDto.idChambre(),
                            chambreDto.numeroChambre(),
                            chambreDto.typeC(),
                            chambreDto.hotelId()
                            , hotelDto);
                })
                .collect(Collectors.toList());
    }

    public void deleteChambreById(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getChambreByType(TypeChambre type) {
        return chambreRepository.findByTypeC(type);
    }
    @Override
    public Chambre getChambre(long id) {
        return chambreRepository.findById(id).orElse(null);
    }
}



