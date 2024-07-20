package com.example.chambre.dto;

import com.example.chambre.entity.TypeChambre;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChambreRequest {
    private Long idChambre;
    private long numeroChambre;
    private TypeChambre typeC;
    private long idBloc;
}
