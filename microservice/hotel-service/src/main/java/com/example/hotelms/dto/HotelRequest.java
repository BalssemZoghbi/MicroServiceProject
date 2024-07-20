package com.example.hotelms.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelRequest {
    private String name;
    private String address;
}
