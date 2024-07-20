package com.example.chambre.services;

import org.apache.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class IHotelServiceRestTemplate {
    RestTemplate restTemplate = new RestTemplate():

    @value("param.baseurl")
    private String baseURL="http://localhost:8082/api/hotel";

    public HotelDto getHotelById(long id){
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity
    }
}
