package com.example.chambre.controllers;


import com.example.chambre.entity.Chambre;
import com.example.chambre.services.IChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambre")
public class ChambreController {


    @Autowired
    IChambreService iChambreService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Chambre> AllChambres() {
        return iChambreService.AllChambres();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    Chambre addChambre(@RequestBody Chambre c) {
        return iChambreService.addChambre(c);
    }

    @PutMapping("/update")
    Chambre updateChambre(@RequestBody Chambre c) {
        return iChambreService.updateChambre(c);
    }

    @GetMapping("/display/{idchambre}")
    Chambre retrieveChambre(@PathVariable("idchambre") long idChambre) {
        return iChambreService.getChambre(idChambre);
    }

    @DeleteMapping("/delete/{idchambre}")
    String removeChambre(@PathVariable("idchambre") long idChambre) {
        iChambreService.deleteChambre(idChambre);
        return ("Chambre est supprimer");
    }

}
