package com.example.hotelms.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(value= "Hotel")
public class Hotel {
    @Id
    private String hotelId;
    private String name;
    private String address;
}
