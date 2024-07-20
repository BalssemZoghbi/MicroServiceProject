package com.example.chambre.services;

import com.example.chambre.entity.Chambre;
import com.example.chambre.entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> AllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    Chambre getChambre(long idChambre);

    void deleteChambre(long idChambre);


    List<Chambre> getChambreByType(TypeChambre type);
}
