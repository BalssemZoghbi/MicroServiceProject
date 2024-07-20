package com.example.chambre.repositories;

import com.example.chambre.entity.Chambre;
import com.example.chambre.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    Chambre findChambreByIdChambre(long idChambre);

    Chambre findChambresByNumeroChambre(long num);

    List<Chambre> findByTypeC(TypeChambre type);
}
