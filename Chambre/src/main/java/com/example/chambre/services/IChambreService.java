package com.example.chambre.services;

import com.example.chambre.dto.ChambreDto;
import com.example.chambre.entity.Chambre;
import com.example.chambre.entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    ChambreDto getChambreById(Long idChambre);
    ChambreDto saveChambre(ChambreDto chambreDto);
    ChambreDto updateChambre(ChambreDto chambreDto);
    List<ChambreDto> AllChambres();
    void deleteChambreById(Long idChambre);
    List<Chambre> getChambreByType(TypeChambre type);
    Chambre getChambre(long id);
}
