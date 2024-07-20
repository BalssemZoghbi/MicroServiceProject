package com.example.chambre.services;

import com.example.chambre.entity.Chambre;
import com.example.chambre.entity.TypeChambre;
import com.example.chambre.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ChambreServiceImpl implements IChambreService{
    @Autowired
    ChambreRepository chambreRepository;


    @Override
    public List<Chambre> AllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre getChambre(long idChambre) {
        System.out.println("get");
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void deleteChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }


    @Override
    public List<Chambre> getChambreByType(TypeChambre type) {
        return chambreRepository.findByTypeC(type);
    }



}

